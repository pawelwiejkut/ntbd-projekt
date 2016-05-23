package warehouse.classes;

import javax.persistence.*;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
public class Customer extends Company {


    @OneToOne
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
