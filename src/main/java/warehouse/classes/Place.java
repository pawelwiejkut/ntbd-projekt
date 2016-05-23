package warehouse.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String rackNumb;
    private String positNumb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRackNumb() {
        return rackNumb;
    }

    public void setRackNumb(String rackNumb) {
        this.rackNumb = rackNumb;
    }

    public String getPositNumb() {
        return positNumb;
    }

    public void setPositNumb(String positNumb) {
        this.positNumb = positNumb;
    }
}
