package com.denys.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
public class OrderEnquiry {

    @Id
    @GeneratedValue
    private long id;

    private String customerName;
    private int amount;
    private Instant created;

    @ManyToOne
    private Product product;

    public OrderEnquiry(String customerName, int amount, Instant created) {
        this.customerName = customerName;
        this.amount = amount;
        this.created = created;
    }

    public OrderEnquiry() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
