import org.hibernate.Query;
import org.hibernate.Session;
import warehouse.classes.Invoice;
import warehouse.classes.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by pawelwiejkut on 27.05.2016.
 */
public class Crud {

    ArrayList<Object> objectList = new ArrayList<Object>();


    public Item insertItem(){
        String name;
        Double value;
        int tax;
        Item item = new Item();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert item name");
        name = scanner.next();
        item.setName(name);

        System.out.println("Insert item value");
        value = scanner.nextDouble();
        item.setValue(value);

        System.out.println("Insert item tax");
        tax = scanner.nextInt();
        item.setTax(tax);
        return item;

    }


    public Invoice insertInvoice(){
        String number;
        Double value;
        Date date;
        String dateGetFUser;
        int choice;
        Scanner scanner = new Scanner(System.in);
        Invoice invoice = new Invoice();

        System.out.println("Insert invoice number");
        number = scanner.next();
        invoice.setInvNumber(number);

        System.out.println("Insert invoice value");
        value = scanner.nextDouble();
        invoice.setValue(value);

        System.out.println("Insert invoice date");
        dateGetFUser = scanner.next();

        System.out.println("Do you want to add items ?");
        System.out.println("1 = Yes");
        System.out.println("2 = No");
        choice = scanner.nextInt();

        if (choice == 1){
            System.out.println("Do you want to add next item ?");
            System.out.println("1 = Yes");
            ArrayList<Item> itemList = new ArrayList<Item>();

            choice = scanner.nextInt();
            if (choice == 1) {
                itemList.add(insertItem());
            }

            for (Item item:itemList) {
                invoice.addItem(item);
            }
        }
        return invoice;
    }

    public static void moveProductbyValue(Session session){
        //select * from warehouse_supplier inner join supplier on warehouse_supplier.SUPPLIER_ID = supplier.ID inner join invoice on invoice_id = invoice.id inner join warehouse on warehouse_id=warehouse.id where value < 4000;
        Double value;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert value to move goods between warehouses");
        value = scanner.nextDouble();

        String hql = "UPDATE Warehouse war set war.name='produkcyjny' "+
                "where war.id in  "+
                "(SELECT war.id FROM Warehouse as war inner "+
                "join war.supplier as sup where sup.invoice.value>"+value+")";

        Query query = session.createQuery(hql);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
    }
}
