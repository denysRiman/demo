package com.denys.demo.Controllers;

import com.denys.demo.Models.OrderEnquiry;
import com.denys.demo.Models.Product;
import com.denys.demo.Models.ProductDto;
import com.denys.demo.Repositories.OrderEnquiryRepository;
import com.denys.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.List;

@Controller
public class RestController {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderEnquiryRepository orderEnquiryRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }


    @Transactional
    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(
            @RequestBody Product product){
        Instant created = Instant.now();
        product.setCreated(created);
        entityManager.persist(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id){
        Product product = productRepository.findById(id);
        ProductDto productDto = new ProductDto(product.getId(), product.getName());
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/param", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getProductById(@RequestParam("id") long id){
        Product product = productRepository.findById(id);
        ProductDto productDto = new ProductDto(product.getId(), product.getName());
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }


    @RequestMapping(value = "/orderEnqueries",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderEnquiry>> getAllOrderEnquiries(){
        return new ResponseEntity<>(orderEnquiryRepository.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/orderEnqueries/{productId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderEnquiry>> getOrderEnquiryByProductId(@PathVariable long productId){

        Product product = productRepository.findById(productId);
        List<OrderEnquiry> orderEnquiries = orderEnquiryRepository.findAllByProduct(product);
        return new ResponseEntity<>(orderEnquiries,HttpStatus.OK);
    }

}
