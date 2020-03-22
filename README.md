# springcloud_demo
springcloud_demo
# Eureka
> Eureka包含两个组件
- Eureka Server
- Eureka Client
> Eureka 单机架构图
![](https://raw.githubusercontent.com/zjajxzg/figure_bed_public/master/github_img/eureka_%E5%8D%95%E6%9C%BA%E6%9E%B6%E6%9E%84.png)

## Eureka集群原理说明
服务注册：将服务信息注册进注册中心
服务发现：从注册中心上获取服务信息
实质：存key服务名 取value调用地址

1、先启动eureka注册中心
2、启动服务提供者payment支付服务
3、支付服务启动后会把自身信息（比如服务地址以别名的方式注册进eureka）
4、消费者order服务在需要调用接口时，使用使用服务别名去注册中心获取实际的RPC远程调用地址
5、消费者获取调用地址后，底层实际是利用HttpClient技术实现远程调用
6、消费者获取服务地址后会缓存在本地JVM内存中，默认每间隔30秒更新一次服务调用地址

微服务RPC远程调用最核心的是什么?
    高可用 如果只有一个注册中心 宕机会导致整个微服务环境不可用
    搭建Eureka注册中心集群 实现负载均衡+故障容器