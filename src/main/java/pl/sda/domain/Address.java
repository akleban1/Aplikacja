package pl.sda.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private static final long serialVersionUID = -530086768384258062L;
    private String doorNo;
    private String streetName;
    private String areaName;
    private String state;
    private String country;
    private String zipCode;
}
