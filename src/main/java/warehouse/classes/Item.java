package warehouse.classes;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private Double value;
    private int tax;
    @ManyToMany
    private Set <Invoice> invoice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public Set getInvoice() {
        if (invoice == null) {
            invoice = new HashSet();
        }
        return invoice;

    }

    public void addInvoice(Invoice invoice){
        getInvoice().add(invoice);
    }


}
