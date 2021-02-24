package com.halodoc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NOTE: table name and entity name are different.
 */

@Entity
@Table(name="aliens")
public class Aliens {

    @Id
    @Column(name="id")
    private int id;

    /**
     * If you use @Transient here it won't create the column username it simply ignores it.
     */


    private AlienName name;

    @Column(name="color")
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
