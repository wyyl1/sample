# Spring Cloud入门之二、服务发现

## eureka-service 服务注册/发现中心
[官方参考文档](https://spring.io/blog/2017/10/31/spring-cloud-finchley-m3-released)

### 复制必备
1. pom.xml
2. application.yml
3. EurekaServiceApplication.java中@EnableEurekaServer

## airport-service 机场服务（通过Spring Eureka注册服务）
### 复制必备
1. pom.xml
2. application.yml
3. AirportServiceApplication.java中@EnableEurekaClient

### 查看结果
#### 前置条件
- eureka-service启动后至少1分钟
- airport-service启动后观察eureka-service接收到3次心跳

#### 查看方法
- 格式 http://<eureka service>:8761/eureka/apps/<APPID>
- 示例 http://localhost:8761/eureka/apps/airportservice
- 默认返回XML格式，返回JSON必须将HTTP的请求头Accept设置为application/json


## aircraft-service 飞机服务（使用服务发现来查找服务）
### 复制必备
1. pom.xml
2. application.yml
3. AircraftServiceApplication.java中getRestTemplate()

### 查看结果
http://localhost:8100/v1/aircraft/HangZhou/
