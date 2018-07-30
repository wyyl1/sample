package com.aoeai.aircraft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * airportName 机场名称
 * 飞机控制类
 */
@RestController
@RequestMapping(value="v1/aircraft/{airportName}")
public class AircraftController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String landing(@PathVariable("airportName") String airportName) {

        return "降落的" + getAirport(airportName);
    }

    /**
     * 从airportservice获得机场名称
     * @param airportName
     * @return
     */
    private String getAirport(String airportName){
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://airportservice/v1/airport/" + airportName + "/",
                        HttpMethod.GET,
                        null, String.class, airportName);

        return restExchange.getBody();
    }
}
