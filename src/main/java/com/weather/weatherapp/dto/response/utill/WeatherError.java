package com.weather.weatherapp.dto.response.utill;

import java.io.Serializable;

public class WeatherError implements Serializable {

    private static final long serialVersionUID = -6850666922914076666L;

    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
