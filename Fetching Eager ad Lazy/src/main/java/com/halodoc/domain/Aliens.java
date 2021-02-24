package com.halodoc.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="aliens")
public class Aliens {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    /**
     *
     * when we use fetch type as eager it will parse the whole thing and we don't have to again fetch the data.
     * It will parse all the data in one query.
     */
    @OneToMany(mappedBy = "aliens",fetch = FetchType.EAGER)
    private Set<Laptop> laptops=new HashSet<Laptop>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }
}
