# springcloudexample
spring cloud 学习例子<br>

服务发现（Eureka）<br>
&emsp;&emsp;eureka-server(服务注册中心) http://localhost:1001/ <br>
&emsp;&emsp;eureka-client(服务提供方)http://localhost:2001/demo <br>
&emsp;&emsp;Note:先启动注册中心然后启动服务提供者<br>
&emsp;&emsp;Eureka简介:http://www.cnblogs.com/wangdaijun/p/6851027.html
<p>
Spring Cloud Consul项目是针对Consul的服务治理实现<br>
&emsp;&emsp;Consul特性:服务发现,健康检查,Key/Value存储,多数据中心<br>
&emsp;&emsp;由于Consul自身提供了服务端，所以我们不需要像之前实现Eureka的时候创建服务注册中心，<br>
&emsp;&emsp;直接通过下载consul的服务端程序就可以使用。<br>
&emsp;&emsp;consul怎么在windows下安装:http://blog.csdn.net/forezp/article/details/70188595<br>
&emsp;&emsp;consul下载地址：https://www.consul.io/downloads.html<br>
&emsp;&emsp;windows pc 环境变量设置 在path下加上：E:\programfiles\consul； cmd启动运行 consul agent -dev<br>
&emsp;&emsp;consul默认地址：http://localhost:8500<br>
&emsp;&emsp;访问demo:http://localhost:3001/demo<br>
&emsp;&emsp;服务发现系统consul介绍:http://www.tuicool.com/articles/j2YVB3<br>
<p>
断路器（Hystrix）<br>
智能路由（Zuul）<br>
客户端负载均衡（Ribbon）<br>

