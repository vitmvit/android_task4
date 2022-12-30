package com.clevertec.hometask4.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtmDto {

    private Long id;
    private String area;
    private String city_type;
    private String city;
    private String address_type;
    private String address;
    private String house;
    private String install_place;
    private String work_time;
    private String gps_x;
    private String gps_y;
    private String install_place_full;
    private String work_time_full;
    private String ATM_type;
    private String ATM_error;
    private String currency;
    private String cash_in;
    private String ATM_printer;
}

