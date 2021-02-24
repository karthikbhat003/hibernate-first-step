package com.halodoc.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="laptop")
public class Laptop {

    @Id
    @Column (name="id")
    private int laptopId;

    @Column(name="laptop_name")
    private String laptopName;

    /**
     * here @ManyToMany specifies that relationship is many to many from here to there.
     * means multiple laptop belongs to multiple student.
     */
    @ManyToMany(mappedBy = "laptop")
    private Set<Student> student=new HashSet<Student>();

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }
}

