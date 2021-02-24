package com.halodoc;

import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.halodoc.domain.Aliens;
import com.halodoc.domain.Laptop;

public class HibernateApplication {
    public static void main(String[] args) {
        //commented after storing the data

        /**
        Aliens aliens=new Aliens();
        aliens.setId(10);
        aliens.setName("karthik");


        Laptop laptop=new Laptop();
        laptop.setLaptopId(101);
        laptop.setBrand("macbook");
        laptop.setPrice(100);

        aliens.getLaptops().add(laptop);

        laptop.setAliens(aliens);
         */

        Configuration con=new Configuration().configure().addAnnotatedClass(Aliens.class).addAnnotatedClass(Laptop.class);

        SessionFactory sf=con.buildSessionFactory();                 //SessionFactory is an interface

        Session session=sf.openSession();                           //Session is an interface

        Transaction tx= session.beginTransaction();                 //session hs to be started

        //session.save(aliens);
        //session.save(laptop);

        Aliens alienss=session.get(Aliens.class,10);


        //System.out.println(alienss.getName());

        /**
         *
         * By default the fetch type is lazy.
         * And we have to forcefully exract the data.
         *
         * To make it eager make fetch type eager
         *
         *
        Collection<Laptop> laptops=alienss.getLaptops();

        for(Laptop lap:laptops){
            System.out.println(lap.getBrand());
        }

         */
        tx.commit();                                                // update the changes in DB
    }

}
