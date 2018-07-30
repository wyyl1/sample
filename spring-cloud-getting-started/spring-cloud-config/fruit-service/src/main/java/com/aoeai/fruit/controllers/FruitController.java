package com.aoeai.fruit.controllers;

import com.aoeai.fruit.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * v1 版本号
 * 喜欢的水果
 */
@RestController
@RequestMapping(value="v1/fruit/{name}/like")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    /**
     * 获得水果
     * @param name 水果名称
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String getFruit(@PathVariable("name") String name) {

        return fruitService.getFruit(name);
    }
}
