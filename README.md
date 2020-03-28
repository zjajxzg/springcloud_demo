# springcloud_demo
springcloud_demo
# Eureka
> Eureka包含两个组件
- Eureka Server
- Eureka Client
> Eureka 单机架构图
![](https://raw.githubusercontent.com/zjajxzg/figure_bed_public/master/github_img/eureka_%E5%8D%95%E6%9C%BA%E6%9E%B6%E6%9E%84.png)

## Eureka集群原理说明
1. 服务注册：将服务信息注册进注册中心
2. 服务发现：从注册中心上获取服务信息
3. 实质：存key服务名 取value调用地址
- 集群流程

    1. 先启动eureka注册中心
    2. 启动服务提供者payment支付服务
    3. 支付服务启动后会把自身信息（比如服务地址以别名的方式注册进eureka）
    4. 消费者order服务在需要调用接口时，使用使用服务别名去注册中心获取实际的RPC远程调用地址
    5. 消费者获取调用地址后，底层实际是利用HttpClient技术实现远程调用
    6. 消费者获取服务地址后会缓存在本地JVM内存中，默认每间隔30秒更新一次服务调用地址

- 微服务RPC远程调用最核心的是什么?
    1. 高可用 如果只有一个注册中心 宕机会导致整个微服务环境不可用
    2. 搭建Eureka注册中心集群 实现负载均衡+故障容器
    
## Eureka自我保护
**概述**
1. 保护模式主要用于一组客户端和Eureka Server之间存在网络分区场景下的保护。一旦进入保护模式，
Eureka Server将会尝试保护服其服务注册表中的信息，不再删除服务注册表中的数据。也就是不会注销任何微服务。

如果Eureka Server的首页看到以下这段提示，则说明Eureka进入了保护模式
> EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
  DS Replicas