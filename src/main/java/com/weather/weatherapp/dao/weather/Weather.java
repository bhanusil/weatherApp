package com.weather.weatherapp.dao.weather;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Weather {

    @Id
    @GeneratedValue
    private Long id;
    private String cityName;
    private String weather;
    private String wind;
    private String temperature;
    private Date updatedTime;

    public Weather() {
        super();
    }

    public Weather(Long id, String cityName, String weather, String wind, String temperature, Date updatedTime) {
        super();
        this.id = id;
        this.cityName = cityName;
        this.weather = weather;
        this.wind = wind;
        this.temperature = temperature;
        this.updatedTime = updatedTime;
    }

    public Weather(String cityName, String weather, String wind, String temperature, Date updatedTime) {
        super();
        this.cityName = cityName;
        this.weather = weather;
        this.wind = wind;
        this.temperature = temperature;
        this.updatedTime = updatedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, cityName=%s, weather=%s]", id, cityName, weather);
    }

}