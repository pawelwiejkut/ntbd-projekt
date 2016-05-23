import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;


    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();


            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }


    public static void main(final String[] args) throws Exception {
        final Session session = getSession();

        GenerateData gd= new GenerateData();
        ArrayList<Object> objectList = new ArrayList<Object>();
        objectList = gd.generateAll();

        try {
            session.beginTransaction();

            for (Object ob : objectList) {
                session.save(ob);

            }

            session.getTransaction();
            session.getTransaction().commit();

        }

        catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

         finally {
            session.close();
        }
    }
}
