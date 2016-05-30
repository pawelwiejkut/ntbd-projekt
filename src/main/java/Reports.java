import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

/**
 * Created by pawelwiejkut on 29.05.2016.
 */
public class Reports {


    public static void goodsBySupplyDate(Session session){
        int itemValue;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert item value");
        itemValue = scanner.nextInt();
        String hql = "select max(cust.lastInvoice.value) FROM Customer as cust inner join cust.lastInvoice.item as item where item.value>"+itemValue;
        Query query = session.createQuery(hql);
        List results = query.list();
        for (Object ob:results) {
            System.out.println(ob.toString());
        }
    }

    public static void groupGoods(Session session){
        String hql = "select name, count(place.name) FROM Goods group by name ";
        Query query = session.createQuery(hql);
        List results = query.list();
        for (Object ob:results) {
            Object[] row = (Object[])ob;
            System.out.println(row[0]+" "+row[1]);
        }

    }

    public static void mustSupply(Session session) {
        int days;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert item value");
        days = scanner.nextInt();
        String hql = "select goods.name, sup.deliveryTimeDays, goods.dailyCons, "+days+"*goods.dailyCons FROM Warehouse as war "+
                "inner join war.goods as goods inner join war.supplier "+
                "as sup where sup.deliveryTimeDays<"+days;
        Query query = session.createQuery(hql);
        List results = query.list();
        for (Object ob:results) {
            Object[] row = (Object[])ob;
            System.out.println(row[0]+" "+row[1]+" "+row[2]+" "+row[3]);
        }
    }

}
