package simple.blog.app;

import org.hibernate.Session;
import simple.blog.app.persistence.HibernateUtil;

public class App
{
    public static void main( String[] args )
    {
        /*Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();*/
        /*UserEntity user = new UserEntity();
        user.setLogin("nastya");
        user.setPassword("123345");
        user.setRole("admin");
        session.save(user);
        session.getTransaction().commit();*/
    }
}
