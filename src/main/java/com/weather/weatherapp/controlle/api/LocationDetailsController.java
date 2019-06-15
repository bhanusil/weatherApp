package com.weather.weatherapp.controlle.api;

import com.weather.weatherapp.dto.request.WeatherDetailsRequestDTO;
import com.weather.weatherapp.dto.response.utill.WeatherResponse;
import com.weather.weatherapp.service.WeatherAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class LocationDetailsController {

    @Autowired
    private WeatherAppService weatherAppService;

    @PostMapping(value = "/weather-details")
    public WeatherResponse getLocationWeather(@RequestBody WeatherDetailsRequestDTO weatherDetailsRequestDTO){

        return weatherAppService.getWeatherDetails(weatherDetailsRequestDTO.getLocationCode());
    }
}
