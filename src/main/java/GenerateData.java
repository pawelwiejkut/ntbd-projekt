import generatedata.DataFactory.impl.DataFactExt;
import warehouse.classes.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pawelwiejkut on 21.05.2016.
 */
public class GenerateData {

    private static DataFactExt df;


    public static Address generateAddress(){
        df = new DataFactExt();
        Address adr = new Address();
        adr.setCity(df.getAddress());
        adr.setPostCode(df.getAddressLine2());
        adr.setStreet(df.getAddress());
        adr.setStreetNumb(String.valueOf(df.getNumberBetween(1,100)));
        return adr;
    }

    public static Customer generateCustomer(){
        df= new DataFactExt();
        Customer cust = new Customer();
        Random random = new Random();
        cust.setName(df.getCompanyName());
        cust.setTaxIdNumb(String.valueOf(df.getNumberBetween(1000,10000)));
        cust.setActive(random.nextBoolean());
        cust.setTransportTime(String.valueOf(df.getNumberBetween(1,30)));
        return cust;
    }

    public static Item generateItem(){
        df = new DataFactExt();
        Item item = new Item();
        item.setName(df.getItemName());
        item.setTax(df.getNumberBetween(1,23));
        item.setValue(Double.valueOf(df.getNumberBetween(1,100000)));
        return item;
    }

    public static Invoice generateInvoice(){
        df = new DataFactExt();
        Invoice inv = new Invoice();
        inv.setInvNumber(String.valueOf(df.getNumberBetween(2000,999999999)));
        inv.setDateOfInv(df.getBirthDate());
        return inv;
    }

    public static Supplier generateSupplier(){
        df= new DataFactExt();
        Supplier sup = new Supplier();
        sup.setName(df.getCompanyName());
        sup.setTaxIdNumb(String.valueOf(df.getNumberBetween(10000,10000)));
        sup.setNextSupplyDate((df.getEmployeeHireDate()));
        sup.setLastSupplyDate((df.getEmployeeHireDate()));
        return sup;
    }

    public static Place generatePlace(){
        df = new DataFactExt();
        Place plac = new Place();
        plac.setName(df.getPlaceName());
        plac.setPositNumb(String.valueOf(df.getNumberBetween(1,100)));
        plac.setRackNumb(String.valueOf(df.getNumberBetween(1,100)));
        return plac;
    }

    public static Goods generateGoods(){
        df = new DataFactExt();
        Goods goods = new Goods();
        goods.setName(df.getItemName());
        goods.setTax(df.getNumberBetween(1,23));
        goods.setValue(Double.valueOf(df.getNumberBetween(1,100000)));
        goods.setDailyCons(Double.valueOf(df.getNumberBetween(1,100)));
        goods.setDateOfRecipt(df.getEmployeeHireDate());
        return goods;
    }

//    public static Warehouse generateWarehouse(){
//        df = new DataFactExt();
//        Warehouse ware = new Warehouse();
//        return ware;
//    }



    public static ArrayList<Object> generateAll() {

        ArrayList<Object> objectList = new ArrayList<Object>();

        for (int i = 0; i < 50; i++) {
            Address adr;
            Address adr2;
            Customer cust;
            Item item;
            Item item2;
            Invoice inv;
            Invoice inv2;
            Supplier sup;
            Place plac;
            Goods goods;
            Warehouse ware = new Warehouse();
            Warehouse ware2 = new Warehouse();


            adr = generateAddress();
            adr2 = generateAddress();
            cust = generateCustomer();
            item = generateItem();
            item2 = generateItem();
            inv = generateInvoice();
            inv2 =  generateInvoice();
            sup = generateSupplier();
            plac = generatePlace();
            goods = generateGoods();

            cust.setAddress(adr);
            sup.setAddress(adr2);
            inv.addItem(item);
            inv.setValue(item.getValue());
            inv2.addItem(item2);
            inv2.setValue(item.getValue());
            item.addInvoice(inv);
            cust.setLastInvoice(inv);
            sup.setInvoice(inv2);
            goods.addInvoice(inv);
            goods.setCustomer(cust);
            goods.setSupplier(sup);
            goods.setPlace(plac);

            ware.addSupplier(sup);
            ware.addCustomer(cust);
            ware.addGoods(goods);
            ware.setName("podstawowy");
            ware2.setName("produkcyjny");


            objectList.add(ware);
            objectList.add(ware2);
            objectList.add(adr);
            objectList.add(adr2);
            objectList.add(cust);
            objectList.add(item);
            objectList.add(item2);
            objectList.add(inv);
            objectList.add(inv2);
            objectList.add(sup);
            objectList.add(plac);
            objectList.add(goods);

        }
        return objectList;
    }

}
