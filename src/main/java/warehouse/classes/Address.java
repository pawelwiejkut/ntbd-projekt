package warehouse.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String city;
    private String street;
    private String streetNumb;
    private String postCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumb() {
        return streetNumb;
    }

    public void setStreetNumb(String numOfBuilding) {
        this.streetNumb = numOfBuilding;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + streetNumb + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}


