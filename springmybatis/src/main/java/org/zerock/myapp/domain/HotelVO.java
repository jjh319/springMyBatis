package org.zerock.myapp.domain;


import lombok.Value;

@Value
public class HotelVO {
    private Integer city;
    private String name;
    private String address;
    private String zip;
} // end class
