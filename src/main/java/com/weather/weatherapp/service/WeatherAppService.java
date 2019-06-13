package com.weather.weatherapp.service;

import com.weather.weatherapp.dto.LocationDetailsDTO;
import com.weather.weatherapp.dto.response.WeatherDetailsResponseDTO;
import com.weather.weatherapp.dto.response.utill.WeatherResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherAppService {

    public List<LocationDetailsDTO> getLocationList(){
        List<LocationDetailsDTO> locationDetailsList = new ArrayList<>();
        LocationDetailsDTO locationDetailsDTO = null;

        locationDetailsDTO = new LocationDetailsDTO();
        locationDetailsDTO.setName("Colombo");
        locationDetailsDTO.setCode("CMB");
        locationDetailsList.add(locationDetailsDTO);

        locationDetailsDTO = new LocationDetailsDTO();
        locationDetailsDTO.setName("Galle");
        locationDetailsDTO.setCode("GAL");
        locationDetailsList.add(locationDetailsDTO);


        if(locationDetailsList == null){
            return null;
        } else if(locationDetailsList.isEmpty()){
            locationDetailsList = new ArrayList<>();
            LocationDetailsDTO locationDetailsTemp = new LocationDetailsDTO();
            locationDetailsTemp.setName("No Location found");
            locationDetailsTemp.setCode("0");
        }
        return locationDetailsList;
    }

    public WeatherResponse getWeatherDetails(String locationCode){
        WeatherDetailsResponseDTO weatherDetailsResponseDTO = new WeatherDetailsResponseDTO();
        weatherDetailsResponseDTO.setName("Test11111");
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setStatus(Boolean.TRUE);
        weatherResponse.setData(weatherDetailsResponseDTO);
        return weatherResponse;
    }
}
