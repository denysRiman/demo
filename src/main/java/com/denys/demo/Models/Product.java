package com.denys.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double price;
    private int amount;
    private Instant created;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Collection<OrderEnquiry> orderEnquiries;

    public Product() {
    }

    public Product(String name, double price, int amount, Instant created) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Collection<OrderEnquiry> getOrderEnquiries() {
        return orderEnquiries;
    }

    public void setOrderEnquiries(Collection<OrderEnquiry> orderEnquiries) {
        this.orderEnquiries = orderEnquiries;
    }
}
