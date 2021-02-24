package com.halodoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.halodoc.domain.Laptop;
import com.halodoc.domain.Student;

/**
 * In this another one column in student table will be created
 * and it will have laptop primary key as the foreign key
 *
 */

public class HibernateApplication {
    public static void main(String[] args) {

        Laptop laptop=new Laptop();
        laptop.setLaptopId(101);
        laptop.setLaptopName("MacBook");

        Student student=new Student();
        student.setRollNumber(003);
        student.setName("karthik");

        student.setLaptop(laptop);                  //this will add the laptop relationship with student

        student.setMarks(60);

        //you have to specify both the annotated class here
        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);


        SessionFactory sf=con.buildSessionFactory();                 //SessionFactory is an interface

        Session session=sf.openSession();                           //Session is an interface

        Transaction tx= session.beginTransaction();                 //session hs to be started

        session.save(student);
        session.save(laptop);

        tx.commit();                                                // update the changes in DB
    }
}
