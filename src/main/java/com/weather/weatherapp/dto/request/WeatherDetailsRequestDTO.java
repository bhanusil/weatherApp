package com.weather.weatherapp.dto.request;

import java.io.Serializable;

public class WeatherDetailsRequestDTO implements Serializable {

    private String locationCode;

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}
