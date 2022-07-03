package services;

import entities.Info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

public class InfoImplementation {

    static Session session;
    static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        // Turn Hibernate logging off
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Info.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    //    Option 1 - Add location
    public static void addLocation() {
        Scanner scanner = new Scanner(System.in);
        Info info = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            info = new Info();
            System.out.print("Vendos Qyetetin: ");
            info.setQyteti(scanner.nextLine());
            System.out.print("Vendos Shtetin: ");
            info.setShteti(scanner.nextLine());
            session.save(info);

            session.getTransaction().commit();
            System.out.println("Shtuar ne databaze");
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
    public static Info deleteLocationById() {
        Info info = null;
        try {
            Scanner scanner=new Scanner(System.in);
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            System.out.println("Jepni ID");
            info = (Info) session.get(Info.class,scanner.nextInt());
            session.delete(info);
            session.getTransaction().commit();
            System.out.println("Fshirja u krye me success");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Id nuk gjendet");
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return info;

    }


}
