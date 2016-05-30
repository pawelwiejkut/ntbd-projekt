package warehouse.classes;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class Customer extends Company {


    @OneToOne (cascade = {CascadeType.ALL})
    private Invoice lastInvoice;
    private Boolean isActive;
    private String transportTime;

    public Invoice getLastInvoice() {
        return lastInvoice;
    }

    public void setLastInvoice(Invoice lastInvoice) {
        this.lastInvoice = lastInvoice;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getTransportTime() {
        return transportTime;
    }

    public void setTransportTime(String transportTime) {
        this.transportTime = transportTime;
    }
}
