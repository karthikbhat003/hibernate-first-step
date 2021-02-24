package com.halodoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.halodoc.domain.AlienName;
import com.halodoc.domain.Aliens;

/**
 * in hibernate.cfg.xml file  <property name="hbm2ddl.auto">update</property>
 * NOTE: if you make craete instead of update it drops old table and creates table every time.
 * This will create table in DB and if present then won't
 * And it updates the data into the table according to the attributes
 *
 * <property name="show_sql">true</property>
 * This will show the sql query created every time when you run the application.
 */

public class HibernateApplication {
    public static void main(String[] args) {

        Aliens user=new Aliens();                       //Creating the object

        AlienName alienName=new AlienName();

        //embedded data field
        alienName.setFirstName("karthik");
        alienName.setMiddleName("ramachandra");
        alienName.setLastName("Bhat");


        //Original entity attributes
        user.setColor("red");
        user.setId(1);
        user.setName(alienName);


        //configure hibernate
        //hibernate.cfg.xml file should be under the resources and not inside the META-INF folder.
        Configuration con=new Configuration().configure().addAnnotatedClass(Aliens.class);

        /**
         * NOTE: we have to add one class service registry here that is not avialble here
         * just a make a note of it.
         * ServiceRegistry reg= new ServiceRegistryBuilder.applySettings(con.getProperties()).buildServiceRegistry();
         * after that pass this reg object inside the buildSessionFactory
         */

        SessionFactory sf=con.buildSessionFactory();                 //SessionFactory is an interface

        Session session=sf.openSession();                           //Session is an interface

        Transaction tx= session.beginTransaction();                 //session hs to be started

        session.save(user);                                         //Save the session

        //user=(Aliens) session.get(Aliens.class,1);          //To retrieve the data from DB

        tx.commit();                                                // update the changes in DB



    }
}
