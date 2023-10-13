package org.zerock.myapp.domain;


import lombok.Value;

@Value
public class CityVO {
    private Integer id;
    private String name;
    private String state;
    private String country;
} // end class
