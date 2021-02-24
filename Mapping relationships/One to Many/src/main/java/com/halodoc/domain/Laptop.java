package com.halodoc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="laptop")
public class Laptop {

    @Id
    @Column(name="id")
    private int laptopId;

    @Column(name="laptop_name")
    private String laptopName;

    /**
     * here @ManyToOne specifies that relationship is many to one from here to there.
     * means multiple laptop belongs to one student.
     */
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
