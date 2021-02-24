package com.halodoc.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="id")
    private int rollNumber;

    @Column(name="name")
    private String name;

    @Column(name="marks")
    private int marks;

    /**
     * Here @OneToMany means that the student having one to many relationship in mapping.
     * you have specified the relationship here
     * but you also have to specify in the laptop class also about the student.
     *
     * NOTE: mappedBy tells that in relationship only one of the entity is takes care of mapping.
     * so here everything will be taken care by student.
     *
     * If we don't use mappedBy tag the extra table will be created.
     * So to avooid that we have to use mappedBy tag whenever we are dealing with many relationship.
     */
    @OneToMany(mappedBy = "student")
    private Set<Laptop> laptop=new HashSet<Laptop>();

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Set<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(Set<Laptop> laptop) {
        this.laptop = laptop;
    }
}
