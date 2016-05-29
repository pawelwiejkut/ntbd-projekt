package warehouse.classes;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
public class Goods extends Item {

    private  Date dateOfRecipt;
    @OneToOne (cascade = {CascadeType.ALL})
    private  Customer customer;
    @OneToOne (cascade = {CascadeType.ALL})
    private Supplier supplier;
    @OneToOne (cascade = {CascadeType.ALL})
    private  Place place;
    private  Double dailyCons;


    public Date getDateOfRecipt() {
        return dateOfRecipt;
    }

    public void setDateOfRecipt(Date dateOfRecipt) {
        this.dateOfRecipt = dateOfRecipt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Double getDailyCons() {
        return dailyCons;
    }

    public void setDailyCons(Double dailyCons) {
        this.dailyCons = dailyCons;
    }
}
