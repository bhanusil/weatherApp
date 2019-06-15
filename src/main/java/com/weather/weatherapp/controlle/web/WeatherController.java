package com.weather.weatherapp.controlle.web;

import com.weather.weatherapp.dto.WeatherDetailsDTO;
import com.weather.weatherapp.service.WeatherAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class WeatherController {
    @Autowired
    private WeatherAppService weatherAppService;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        List<WeatherDetailsDTO> locationDetailsList = weatherAppService.getLocationList();
        model.put("locationDetailsList", locationDetailsList);
        return "weather";
    }
}
