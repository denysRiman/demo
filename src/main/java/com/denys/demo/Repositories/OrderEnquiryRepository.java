package com.denys.demo.Repositories;

import com.denys.demo.Models.OrderEnquiry;
import com.denys.demo.Models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEnquiryRepository extends CrudRepository<OrderEnquiry, Long> {

    List<OrderEnquiry> findAll();
    OrderEnquiry findById(long id);

    @Query("select oE from OrderEnquiry oE where oE.product = ?1")
    List<OrderEnquiry> findAllByProduct(Product product);
}
