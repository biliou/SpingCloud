# SpingCloud
搭建Spring Cloud微服务项目

# 目录结构
config-repo    -存放配置中心统一管理的配置文件 <br />
config-server  -Spring Cloud Config 服务端，将git中存储的配置文件发布成REST接口 <br />
config-client  -Spring Cloud Config 客户端，将从server端获取统一配置信息 <br />
eurekaServer   -服务注册中心，用于服务注册与发现 <br />
service-producter1  -服务提供者 <br />
service-consumer  -服务消费者，通过注册中心发现服务提供者 <br />
hystrix-turbine   -熔断集成监控 （未完成）<br />
spring-cloud-zuul -服务网关，用于第三方接口调用后台服务的同一入口 <br />


