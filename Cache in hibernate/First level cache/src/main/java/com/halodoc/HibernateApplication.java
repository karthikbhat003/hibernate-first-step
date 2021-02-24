package com.halodoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.halodoc.domain.Alien;

public class HibernateApplication {
    public static void main(String[] args) {

        Alien alien=new Alien();
        //commented after storing the data
        /**


        alien.setAlienColor("green");
        alien.setAlienId(12);
        alien.setAlienName("karthik2");
         */

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        session1.beginTransaction();

        //session1.save(alien);

        alien=session1.get(Alien.class,10);
        System.out.println(alien.getAlienName());

        /**
         * This won't get executed, this will be stored in cache.
         * It will again won't fire the query because of cache.
         * Because two same queries are fired in the same session.
         */

        alien=session1.get(Alien.class,10);
        System.out.println(alien.getAlienName());

        session1.getTransaction().commit();
        session1.close();

        /**
         * It will go to database in this session because it is another session.
         * It can't access the cache of session 1.
         */
        Session session2 = sf.openSession();
        session2.beginTransaction();

        alien=session2.get(Alien.class,10);
        System.out.println(alien.getAlienName());

        session2.getTransaction().commit();
        session2.close();


    }
}
