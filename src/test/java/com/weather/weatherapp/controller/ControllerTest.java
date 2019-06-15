package com.weather.weatherapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherapp.WeatherappApplicationTests;
import com.weather.weatherapp.dto.LocationDetailsDTO;
import com.weather.weatherapp.dto.request.WeatherDetailsRequestDTO;
import com.weather.weatherapp.dto.response.WeatherDetailsResponseDTO;
import com.weather.weatherapp.dto.response.utill.WeatherResponse;
import com.weather.weatherapp.service.WeatherAppService;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@Transactional
@Rollback(true)
public class ControllerTest extends WeatherappApplicationTests {

    @Mock
    private WeatherAppService weatherAppService;

    private ObjectMapper mapper;

    public ControllerTest() {
        this.mapper = new ObjectMapper();
    }

    @Test
    public void welcome() throws Exception {

        List<LocationDetailsDTO> locationDetailsList = weatherAppService.getLocationList();

        assertNotNull(locationDetailsList);

        verify(weatherAppService, times(1)).getLocationList();
        verifyNoMoreInteractions(weatherAppService);
    }

    @Test
    public void getLocationWeather() throws Exception {
        WeatherDetailsRequestDTO weatherDetailsRequestDTO = mapper.readValue(
                new File("resource/weatherapp/jsonRequestResponse/jUnit/weatherDetailsRequest.json"), WeatherDetailsRequestDTO.class);
        WeatherResponse weatherResponse = mapper.readValue(
                new File("resource/weatherapp/jsonRequestResponse/jUnit/weatherDetailsResponse.json"), WeatherResponse.class);

        when(weatherAppService.getWeatherDetails(weatherDetailsRequestDTO.getLocationCode())).thenReturn(weatherResponse);

        WeatherResponse weatherResponseWs = weatherAppService.getWeatherDetails(weatherDetailsRequestDTO.getLocationCode());

        assertNotNull(weatherResponseWs);

        assertEquals(true, weatherResponseWs.isStatus());
        assertNotNull(weatherResponseWs.getData());

        verify(weatherAppService, times(1)).getWeatherDetails(weatherDetailsRequestDTO.getLocationCode());
        verifyNoMoreInteractions(weatherAppService);
    }

}
