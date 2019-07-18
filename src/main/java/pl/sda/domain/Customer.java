package pl.sda.domain;

import lombok.Data;

import java.io.Serializable;

@Data

public class Customer implements Serializable {
    private static final long serialVersionUID = 2284040482222162898L;
    private String customerId;
    private String name;
    private Address billingAddress;
    private String phoneNumber;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
    public Customer() {
        super();
        this.billingAddress = new Address();
    }
}
