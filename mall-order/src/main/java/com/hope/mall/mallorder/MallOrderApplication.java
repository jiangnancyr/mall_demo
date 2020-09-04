package com.hope.mall.mallorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hope.mall.mallorder.dao")
@SpringBootApplication
public class MallOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallOrderApplication.class, args);
	}

}
