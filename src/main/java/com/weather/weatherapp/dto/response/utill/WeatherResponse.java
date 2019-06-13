package com.weather.weatherapp.dto.response.utill;

import java.io.Serializable;

public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = -1655013025636955366L;

    private boolean status;
    private Object data;
    private WeatherError weatherError;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public WeatherError getWeatherError() {
        return weatherError;
    }

    public void setWeatherError(WeatherError weatherError) {
        this.weatherError = weatherError;
    }
}
