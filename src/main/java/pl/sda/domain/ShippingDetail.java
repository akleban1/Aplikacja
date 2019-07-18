package pl.sda.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShippingDetail implements Serializable {
    private static final long serialVersionUID = 6350930334140807514L;
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date shippingDate;
    private Address shippingAddress;
    public ShippingDetail() {
        this.shippingAddress = new Address();
    }
}
