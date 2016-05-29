package warehouse.classes;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany (cascade = {CascadeType.ALL})
    private Set <Goods> goods;
    @OneToMany (cascade = {CascadeType.ALL})
    private Set <Customer> customer;
    @OneToMany (cascade = {CascadeType.ALL})
    private Set <Supplier> supplier;

    public Set getGoods() {
        if (goods == null) {
            goods = new HashSet();
        }
        return goods;
    }

    public void addGoods(Goods goods) {
        getGoods().add(goods);
    }

    public Set getCustomer() {
        if (customer == null) {
            customer = new HashSet();
        }
        return customer;
    }

    public void addCustomer(Customer customer) {
        getCustomer().add(customer);
    }

    public Set getSupplier() {
        if (supplier == null) {
            supplier = new HashSet();
        }
        return supplier;
    }

    public void addSupplier(Supplier supplier) {
        getSupplier().add(supplier);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
