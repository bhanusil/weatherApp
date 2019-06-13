package com.weather.weatherapp.dto;

import java.io.Serializable;

public class LocationDetailsDTO implements Serializable {
    private static final long serialVersionUID = 5246887524998916360L;

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
