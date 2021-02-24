package com.halodoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.halodoc.domain.Laptop;
import com.halodoc.domain.Student;


public class HibernateApplication {
    public static void main(String[] args) {

        Laptop laptop=new Laptop();
        laptop.setLaptopId(103);
        laptop.setLaptopName("MacBook");

        Student student=new Student();
        student.setRollNumber(5);
        student.setName("karthik");

        //NOTE: we have to get the laptop list first and we have to add to that set.
        //Because you are not having any set of laptop here to directly assign.
        student.getLaptop().add(laptop);

        student.setMarks(60);

        //add all properties of student in laptop entity
        laptop.setStudent(student);

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
