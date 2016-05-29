package warehouse.classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by pawelwiejkut on 20.05.2016.
 */
@Entity
public class Supplier extends Company {

    private Date nextSupplyDate;
    private  Date lastSupplyDate;
    @OneToOne (cascade = {CascadeType.ALL})
    private  Invoice invoice;
    private  int deliveryTimeDays;

    public Date getNextSupplyDate() {
        return nextSupplyDate;
    }

    public void setNextSupplyDate(Date nextSupplyDate) {
        this.nextSupplyDate = nextSupplyDate;
    }

    public Date getLastSupplyDate() {
        return lastSupplyDate;
    }

    public void setLastSupplyDate(Date lastSupplyDate) {
        this.lastSupplyDate = lastSupplyDate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getDeliveryTimeDays() {
        return deliveryTimeDays;
    }

    public void setDeliveryTimeDays(int deliveryTimeDays) {
        this.deliveryTimeDays = deliveryTimeDays;
    }
}
