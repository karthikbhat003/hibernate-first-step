package com.halodoc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="laptop")
public class Laptop {

    @Id
    @Column(name="id")
    private int laptopId;

    @Column(name="brand")
    private String brand;

    @Column(name="price")
    private int price;

    @ManyToOne
    private Aliens aliens;

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Aliens getAliens() {
        return aliens;
    }

    public void setAliens(Aliens aliens) {
        this.aliens = aliens;
    }
}
