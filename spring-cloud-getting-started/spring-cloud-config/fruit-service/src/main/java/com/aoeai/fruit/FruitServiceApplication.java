package com.aoeai.fruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
// @RefreshScope注解只会重新加载应用程序配置中的自定义Spring属性，要执行刷新，可以访问http://<yourserver>:8080/refresh端点。
@RefreshScope
public class FruitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruitServiceApplication.class, args);
    }
}
