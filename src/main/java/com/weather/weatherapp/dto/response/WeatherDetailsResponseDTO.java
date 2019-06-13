package com.weather.weatherapp.dto.response;

import java.io.Serializable;

public class WeatherDetailsResponseDTO implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
