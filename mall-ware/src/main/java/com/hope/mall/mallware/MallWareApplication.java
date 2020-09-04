package com.hope.mall.mallware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hope.mall.mallware.dao")
@SpringBootApplication
public class MallWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallWareApplication.class, args);
	}

}
