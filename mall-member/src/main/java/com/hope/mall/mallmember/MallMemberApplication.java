package com.hope.mall.mallmember;

/**
 * @author cyrcreate
 * @create 2020-09-04 21:57
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.hope.mall.mallmember.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MallMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallMemberApplication.class, args);
    }
}
