
package com.halodoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.halodoc.domain.Laptop;
import com.halodoc.domain.Student;

/**
 * You can use either way mapping.
 * mapped by student or mapped by laptop.
 * usually it is mapped by the child entity.
 */

public class HibernateApplication {
    public static void main(String[] args) {

        Laptop laptop=new Laptop();
        laptop.setLaptopId(103);
        laptop.setLaptopName("MacBook");

        Student student=new Student();
        student.setRollNumber(5);
        student.setName("karthik");
        student.setMarks(60);

        laptop.getStudent().add(student);

        /**
         * mappedBy is written in laptop class and it is indicating that mapping is done by the set of
         * laptop and is present in student class
         * So, all the basic data must be added to laptop class attribute student list.
         * Then we come back to student class and add all the data back in studnet class laptop list attribute.
         * Follow this rule,
         * Otherwise you will get error.
         */

        //NOTE: we have to get the laptop list first and we have to add to that set.
        //Because you are not having any set of laptop here to directly assign.
        student.getLaptop().add(laptop);

        //add all the property of student in laptop


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

