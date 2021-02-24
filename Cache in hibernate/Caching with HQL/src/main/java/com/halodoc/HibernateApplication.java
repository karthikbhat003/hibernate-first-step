package com.halodoc;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.halodoc.domain.Alien;

/**
 * Step 1: Change the pom.xml file
 * Step 2: Change the hibernate.cfg.xml file and add the property.
 * Step 3: Change the version of hibernate to same as ehcache version.(Otherwise error)
 * Step 4: Use the annotation @Cacheable and @Cache to the entity and assign access method.
 * Step 5: Run
 *
 * Link to YouTube: https://www.youtube.com/watch?v=TCHm1h7rBmo&list=PLsyeobzWxl7qBZtsEvp_n2A7sJs2MpF3r&index=18 and
 *                  https://www.youtube.com/watch?v=2hYtMfQ2TnQ&list=PLsyeobzWxl7qBZtsEvp_n2A7sJs2MpF3r&index=19
 */

public class HibernateApplication {
    public static void main(String[] args) {

        System.out.println("Starting with cache");

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();

        Alien alien=new Alien();


        /**
         NOTE: commented after storing the data

         alien.setAlienColor("green");
         alien.setAlienId(12);
         alien.setAlienName("karthik2");

         session1.save(alien);
         */



        //First session

        /**
         * VERY IMPORTANT NOTE:
         *      In HQL query you have to mention the table name same as class name
         *
         *      "from alien where id=10" gives error even if my db table name is alien
         *
         *      It should be
         *
         *      "from Alien where id=10"
         *
         *      Then it will work.
         */


        

        Query q1=session1.createQuery("from Alien where id=10");
        q1.setCacheable(true);
        alien=(Alien)q1.uniqueResult();

        System.out.println(alien.getAlienName());

        session1.getTransaction().commit();
        session1.close();


        //Second session
        Session session2 = sf.openSession();
        session2.beginTransaction();

        Query q2=session2.createQuery("from Alien where id=10");
        q2.setCacheable(true);
        alien=(Alien)q2.uniqueResult();

        System.out.println(alien.getAlienName());

        session2.getTransaction().commit();
        session2.close();
    }
}


