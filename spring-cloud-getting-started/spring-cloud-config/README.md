# Spring Cloud入门之一、Config
拷贝规则在第一次出现时会标有说明，后续相同规则不会特殊说明。
-

# spring-cloud-config

## config-service 配置信息服务
### 复制必备
### 1. pom.xml
- 标有“必须”的都有添加
- Spring Cloud 发行版，保证spring依赖版本的兼容性
- Spring Cloud Config开始

### 2. 必须配置的资源文件
- bootstrap.yml
- application.yml

### 3. ConfigServiceApplication.java中需要添加的内容
- @EnableConfigServer [官方文档](https://spring.io/guides/gs/centralized-configuration/)

### 启动后查看结果
- http://localhost:8888/configserver/default "default可以随便输入"

## fruit-service 读取配置信息
### 复制必备
1. pom.xml
2. bootstrap.yml
3. ServiceConfig.java描述如何读取配置文件

## 注意
配置文件命名请遵守规约，避免不必要的麻烦，请参考以下命名规则

### bootstrap.yml
```vim
spring:
  application:
    name: fruitservice
```

### Git配置文件地址和命名

```vim
# 文件名
fruitservice.yml
fruitservice-dev.yml
fruitservice-prod.yml
```

### 查看读取的配置文件
- 规则：http://config服务器地址/spring.application.name/env
- 示例：http://localhost:8888/fruitservice/env

### spring.profiles.active不同环境下的返回结果

```vim
http://localhost:8080/v1/fruit/apple/like/

default
licensingservice.yml
apple,来自I AM IN THE DEFAULT

dev
licensingservice-dev.yml
apple,来自I AM IN THE DEFAULT
因为文件中没有example.property，所以依然读取default的配置

prod
licensingservice-prod.yml
apple,来自I AM A PROD PROPERTY OVERRIDE
```


