package warehouse.classes;

import javax.persistence.*;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@MappedSuperclass
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    @OneToOne
    private Address address;
    private String taxIdNumb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTaxIdNumb() {
        return taxIdNumb;
    }

    public void setTaxIdNumb(String taxIdNumb) {
        this.taxIdNumb = taxIdNumb;
    }
}
