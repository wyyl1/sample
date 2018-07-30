package com.aoeai.fruit.services;

import com.aoeai.fruit.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    @Autowired
    private ServiceConfig serviceConfig;

    public String getFruit(String name){
        return name + ",来自" + serviceConfig.getExampleProperty();
    }
}
