package com.halodoc.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//You have to use this annotation here
@Cacheable
//This is used to denote the type of operation which needs to be done
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="alien")
public class Alien {

    @Id
    @Column(name="id")
    private int alienId;

    @Column(name="alien_name")
    private String alienName;

    @Column(name="alien_color")
    private String alienColor;

    public int getAlienId() {
        return alienId;
    }

    public void setAlienId(int alienId) {
        this.alienId = alienId;
    }

    public String getAlienName() {
        return alienName;
    }

    public void setAlienName(String alienName) {
        this.alienName = alienName;
    }

    public String getAlienColor() {
        return alienColor;
    }

    public void setAlienColor(String alienColor) {
        this.alienColor = alienColor;
    }
}

