package services;

import entities.Info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    public static void addLocation(){
        Info info=null;
        try{
            session=buildSessionFactory().openSession();
            session.beginTransaction();
            info = new Info();
           info.setQyteti("Tirana");
           info.setShteti("Albania");
            session.save(info);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();

        }
        finally {
            if(session!=null){
                session.close();
            }
        }
    }





}
