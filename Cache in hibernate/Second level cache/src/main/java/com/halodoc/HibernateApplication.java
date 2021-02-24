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
 * Link to YouTube: https://www.youtube.com/watch?v=TCHm1h7rBmo&list=PLsyeobzWxl7qBZtsEvp_n2A7sJs2MpF3r&index=18
 */

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
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();

        //session1.save(alien);
        alien=(Alien) session1.get(Alien.class,10);
        System.out.println(alien.getAlienName());

        /**
         * This won't get executed, this will be stored in cache.
         * It will again won't fire the query because of cache.
         * Because two same queries are fired in the same session.
         */

        alien=(Alien) session1.get(Alien.class,10);
        System.out.println(alien.getAlienName());

        session1.getTransaction().commit();
        session1.close();

        //Another session started here
        Session session2 = sf.openSession();
        session2.beginTransaction();

        alien=(Alien) session2.get(Alien.class,10);
        System.out.println(alien.getAlienName());

        session2.getTransaction().commit();
        session2.close();
    }
}

