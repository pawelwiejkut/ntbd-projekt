package warehouse.classes;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String invNumber;
    private Double value;
    @ManyToMany
    private  Set <Item> item;
    private  Date dateOfInv;

    public String getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(String number) {
        this.invNumber = number;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Set getItem() {
        if (item == null) {
            item = new HashSet();
        }
        return item;
    }

    public void addItem(Item item){
        getItem().add(item);
    }

    public Date getDateOfInv() {
        return dateOfInv;
    }

    public void setDateOfInv(Date date) {
        this.dateOfInv = date;
    }

    public void setItem(Set item) {
        this.item = item;
    }
}
