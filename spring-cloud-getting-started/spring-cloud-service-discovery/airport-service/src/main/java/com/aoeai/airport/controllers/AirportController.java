package com.aoeai.airport.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * v1 版本号
 * name 飞机场名称
 * 飞机场控制类
 */
@RestController
@RequestMapping(value="v1/airport/{name}")
public class AirportController {

    /**
     * 获得飞机场名称
     * @param name 飞机场名称
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String getAirport(@PathVariable("name") String name) {

        return "机场名称：" + name;
    }
}
