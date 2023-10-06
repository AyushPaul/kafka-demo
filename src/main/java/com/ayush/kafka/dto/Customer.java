package com.ayush.kafka.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Customer {

    private int id;
    private String name;
    private String email;
    private String contactNo;

}
