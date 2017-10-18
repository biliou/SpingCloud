# SpingCloud
搭建Spring Cloud微服务项目

# 目录结构
config-repo    -存放配置中心统一管理的配置文件 <br />
config-server  -Spring Cloud Config 服务端，将git中存储的配置文件发布成REST接口 <br />
config-client  -Spring Cloud Config 客户端，将从server端获取统一配置信息 <br />