# springcloudexample
**QQ交流群：374044564**<br>
**添加QQ群获取springboot、springcloud、dubbo等视频教程及资料**<br>
spring cloud 学习例子<br>
在微服务架构中，需要几个关键的组件，服务注册与发现、服务消费、负载均衡、断路器、智能路由、配置管理等，<br>
由这几个组件可以组建一个简单的微服务架构。<br>

<img src="https://github.com/L316476844/springcloudexample/blob/master/springcloud.jpg" alt="">

## 服务发现（Eureka、consul）<br>
+ eureka-server(服务注册中心) http://localhost:1001/ <br>
+ eureka-client(服务提供方)http://localhost:2001/demo <br>
+ eureka-consumer(服务消费者-手动负载均衡)http://localhost:2101/consumer <br>
+ eureka-consumer-ribbon(服务消费者-自动负载均衡)http://localhost:2102/ribbon <br>
+ Eureka简介:http://www.cnblogs.com/wangdaijun/p/6851027.html<br>
+ Eureka简介:http://www.roncoo.com/article/detail/128041<br>
+ **Note:先启动注册中心然后启动服务提供者**<br>

### consul-client(consul服务提供方)
+ Spring Cloud Consul项目是针对Consul的服务治理实现<br>
+ Consul特性:服务发现,健康检查,Key/Value存储,多数据中心<br>
+ 由于Consul自身提供了服务端，所以我们不需要像之前实现Eureka的时候创建服务注册中心，<br>
+ 直接通过下载consul的服务端程序就可以使用:<br>
+ consul怎么在windows下安装:http://blog.csdn.net/forezp/article/details/70188595<br>
+ consul下载地址：https://www.consul.io/downloads.html<br>
+ windows pc 环境变量设置 在path下加上：E:\programfiles\consul； cmd启动运行 consul agent -dev<br>
+ consul默认地址：http://localhost:8500<br>
+ 访问demo:http://localhost:3001/demo<br>
+ 服务发现系统consul介绍:http://www.tuicool.com/articles/j2YVB3<br>

## 声明式REST客户端-Feign的使用<br>
+ Feign是一种声明式、模板化的HTTP客户端。<br>
+ 在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验，开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。<br>
+ eureka-consumer-feign(服务消费者-feign): http://localhost:2103/feign?name=jon<br>
+ **feign是自带断路器的**，此版本hystrix是关闭的 ，如果使用feign想用断路器的话，可以在配置文件中开启它,配置如下：feign.hystrix.enabled=true<br>

## 断路器（Hystrix）<br>
+ eureka-consumer-ribbon-hystrix(服务消费者-断路器)<br>
+ http://localhost:2104/ribbon?name=jon<br>

## 智能路由（zuul）<br>
+ Zuul的主要功能是路由和过滤器。
+ 路由功能是微服务的一部分，比如／api/user映射到user服务，/api/shop映射到shop服务。zuul实现了负载均衡。
+ 依次启动顺序 eureka-server、eureka-client、eureka-consumer、eureka-consumer-feign、eureka-zuul工程
  依次访问下面的路径查看测试效果。
+ http://localhost:3101/baidu
+ http://localhost:3101/index
+ http://localhost:3101/api-a/consumer
+ http://localhost:3101/api-b/feign?name=jon

### 智能路由（zuul）- 过滤器ZuulFilter
+ 过滤器类型返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：filterType如下:
1. pre：路由之前
2. routing：路由之时
3. post： 路由之后
4. error：发送错误调用
5. filterOrder：过滤的顺序
6. shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
7. run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
+ 参考代码 DemoFilter
+ 修改请求地址
1. http://localhost:3101/baidu?token=org.lv.jon.token
2. http://localhost:3101/index?token=org.lv.jon.token
3. http://localhost:3101/api-a/consumer?token=org.lv.jon.token
4. http://localhost:3101/api-b/feign?name=jon&token=org.lv.jon.token

## 分布式配置中心(Spring Cloud Config)
在分布式系统中，spring cloud config 提供一个服务端和客户端去提供可扩展的配置服务。
我们可用用配置服务中心区集中的管理所有的服务的各种环境配置文件。配置服务中心采用Git的方式存储配置文件，
因此我们很容易部署修改，有助于对环境配置进行版本管理。
### config-server
    高可用配置中心 config-eureka-server 使用eureka做为配置服务注册中心,需要启动eureka-server配合使用。
#### 访问配置信息的URL与配置文件的映射关系如下：
* /{application}/{profile}[/{label}]
* /{application}-{profile}.yml
* /{label}/{application}-{profile}.yml
* /{application}-{profile}.properties
* /{label}/{application}-{profile}.properties
application:表示应用名称,在client中通过spring.config.name配置,profile:表示获取指定环境下配置，例如开发环境、测试环境、生产环境 默认值default，实际开发中可以是 dev、test、demo、production等
label: git标签，默认值master
* http://localhost:8888/config-client/dev
### config-client
   **config-client 配置文件必须要使用bootstrap.properties**<br>
    高可用配置中心客户端 config-eureka-client 使用eureka做为配置服务注册中心,需要启动eureka-server，config-eureka-server配合使用。
    http://localhost:8001/jon
* 启动config-server 然后启动config-server  访问http://localhost:8800/jon
### 动态更新配置参数
1. 在客户端启动类添加注解 @RefreshScope 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
2. 在客户端pom增加spring-boot-starter-actuator包，spring-boot-starter-actuator是一套监控的功能，可以监控程序在运行时状态，其中就包括/refresh的功能。
3. springboot 1.5.X 以上默认开通了安全认证，所以需要在配置文件application.properties中关闭安全认证：management.security.enabled=false
4. 以post请求的方式来访问http://localhost:8001/refresh 就会更新修改后的配置文件。
5. 查看更新后的参数 http://localhost:8001/jon

## 消息总线(Spring Cloud Bus)
    SpringCloudConfig分服务端和客户端，服务端负责将git（svn）中存储的配置文件发布成REST接口，客户端可以从服务端REST接口获取配置。
    但客户端并不能主动感知到配置的变化，从而主动去获取新的配置，这需要每个客户端通过POST方法触发各自的/refresh。
    若所有触发操作均需要我们手工去维护系统中的应用位置的话，这随着系统的不断扩张，会变的越来越难以维护，
    而消息代理中间件是解决该问题最为合适的方案。消息代理中间件可以将消息路由到一个或多个目的地。
    利用这个功能，我们就能完美的解决该问题。
<b style="color:red;"> 注意kafka版本与springcloud版本兼容问题本工程spring-cloud-dependencies版本修改为Brixton.SR5 </b>
#### kafka方式实现消息总线 需配合eureka注册中心使用 eureka-server
1. 服务端config-server-eureka-bus
    application.properties配置
    #kafka配置
    spring.cloud.stream.kafka.binder.zk-nodes=192.168.88.177:2181
    spring.cloud.stream.kafka.binder.brokers=192.168.88.177:9092
    pom.xml配置
     <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-kafka</artifactId>
     </dependency>
2. 客服端config-client-eureka-bus
    bootstrap.properties配置
    #kafka配置
    spring.cloud.stream.kafka.binder.zk-nodes=192.168.88.177:2181
    spring.cloud.stream.kafka.binder.brokers=192.168.88.177:9092
    #开启消息跟踪
    spring.cloud.bus.trace.enabled=true
3. Spring Cloud Bus做配置更新步骤如下图:
* 提交代码触发post请求给bus/refresh
* server端接收到请求并发送给Spring Cloud Bus
* Spring Cloud bus接到消息并通知给其它客户端
* 其它客户端接收到通知，请求Server端获取最新配置
* 全部客户端均获取到最新的配置

<img src="https://github.com/L316476844/springcloudexample/blob/master/files/5-7.png" alt="">

#### 局部刷新配置
    某些场景下（例如灰度发布），我们可能只想刷新部分微服务的配置，此时可通过/bus/refresh端点的destination参数来定位要刷新的应用程序。
    例如：/bus/refresh?destination=customers:8000，这样消息总线上的微服务实例就会根据destination参数的值来判断是否需要要刷新。
    其中，customers:8000指的是各个微服务的ApplicationContext ID。
    destination参数也可以用来定位特定的微服务。例如：/bus/refresh?destination=customers:**，这样就可以触发customers微服务所有实例的配置刷新。
#### 跟踪总线事件
    一些场景下，我们可能希望知道Spring Cloud Bus事件传播的细节。此时，我们可以跟踪总线事件（RemoteApplicationEvent的子类都是总线事件）。
    跟踪总线事件非常简单，只需设置spring.cloud.bus.trace.enabled=true，这样在/bus/refresh端点被请求后，访问/trace端点就可获得类。
#### /bus/refresh BUG
    对客户端执行/bus/refresh之后，挂到总线的上的客户端都会从Eureka注册中心撤销登记；
    如果对server端执行/bus/refresh,server端也会从Eureka注册中心撤销登记。
    Spring Cloud的Dalston.SR1版本，解决这个bug.

## 服务链路追踪(Spring Cloud Sleuth)

## 高可用的服务注册中心

## 断路器监控(Hystrix Dashboard)

## 断路器聚合监控(Hystrix Turbine)

