package com.weather.weatherapp.service;

import com.weather.weatherapp.dao.weather.Weather;
import com.weather.weatherapp.dao.weather.WeatherRepository;
import com.weather.weatherapp.dto.LocationDetailsDTO;
import com.weather.weatherapp.dto.response.WeatherDetailsResponseDTO;
import com.weather.weatherapp.dto.response.utill.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherAppService {

    @Autowired
    private WeatherRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<LocationDetailsDTO> getLocationList(){
        List<LocationDetailsDTO> locationDetailsList = new ArrayList<>();
        LocationDetailsDTO locationDetailsDTO = null;

        List<Weather> weatherList = repository.findAll();

        for(Weather vo : weatherList){
            locationDetailsDTO = new LocationDetailsDTO();
            locationDetailsDTO.setCode(vo.getId());
            locationDetailsDTO.setName(vo.getCityName());
            locationDetailsList.add(locationDetailsDTO);
        }

         if(locationDetailsList.isEmpty()){
            locationDetailsList = new ArrayList<>();
            LocationDetailsDTO locationDetailsTemp = new LocationDetailsDTO();
            locationDetailsTemp.setName("No Location found");
            locationDetailsTemp.setCode(0L);
        }
        return locationDetailsList;
    }

    public WeatherResponse getWeatherDetails(String locationCode){
        WeatherResponse weatherResponse = new WeatherResponse();
        WeatherDetailsResponseDTO weatherDetailsResponseDTO;
        Optional<Weather> weatherList = repository.findById(Long.parseLong(locationCode));

        if(weatherList.isPresent()){
            Weather weatherOut = weatherList.get();
            weatherDetailsResponseDTO = objectMapper.convertValue(weatherOut,WeatherDetailsResponseDTO.class);
            DateFormat dateFormat = new SimpleDateFormat("EEEEE HH:mm a");
            String formattedDate = dateFormat.format(weatherOut.getUpdatedTime());
            weatherDetailsResponseDTO.setUpdatedTime(formattedDate);

            weatherResponse.setStatus(Boolean.TRUE);
            weatherResponse.setData(weatherDetailsResponseDTO);
        }else{
            weatherResponse.setStatus(Boolean.FALSE);
        }

        return weatherResponse;
    }
}
