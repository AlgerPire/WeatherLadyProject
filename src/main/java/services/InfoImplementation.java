package services;

import entities.Info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoImplementation {

    static Session session;
    static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Info.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    //    Option 1 - Add location
    public static void addLocation() {
        Info info = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            info = new Info();
            info.setQyteti("Prague");
            info.setShteti("Czechia");
            session.save(info);
            session.getTransaction().commit();
            System.out.println("Added successfully");
        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //Option 2- Show All Location
    public static void listAllData( ){
        Info info = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            List data = session.createQuery("FROM Info").list();
            for (Iterator iterator1 = data.iterator(); iterator1.hasNext();){
                Info info1 = (Info) iterator1.next();
                System.out.print("Id: " + info1.getId());
                System.out.print(" Qyteti: " + info1.getQyteti());
                System.out.println(" Shteti: "+info1.getShteti());
            }
        }  catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
    }


    // Option 3 - Delete Location
    public static Info deleteLocationById(int idNumber) {
        Info info = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            info = (Info) session.get(Info.class, idNumber);
            session.delete(info);
            session.getTransaction().commit();
            System.out.println("Deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Id not found");
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return info;

    }


}
