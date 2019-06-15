package com.weather.weatherapp;

import com.weather.weatherapp.dao.weather.Weather;
import com.weather.weatherapp.dao.weather.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class WeatherappApplication  implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WeatherRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(WeatherappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Inserting -> {}", repository.save(new Weather("Sydney", "Mostly Cloudy", "32km/h", "9°C", new Date())));
        logger.info("Inserting -> {}", repository.save(new Weather("Melbourne", "Rainy", "30km/h", "9°C", new Date())));
        logger.info("Inserting -> {}", repository.save(new Weather("Wollongong", "Mostly Cloudy", "32km/h", "9°C", new Date())));

    }

}
