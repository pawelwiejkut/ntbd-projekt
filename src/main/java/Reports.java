import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by pawelwiejkut on 29.05.2016.
 */
public class Reports {


    public static void goodsBySupplyDate(Session session){
        String hql = "FROM";
        Query query = session.createQuery(hql);
        List results = query.list();
    }

}
