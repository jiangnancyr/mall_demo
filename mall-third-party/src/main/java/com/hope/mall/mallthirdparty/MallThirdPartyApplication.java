package com.hope.mall.mallthirdparty;

import com.kuisama.oss.annotation.EnableAliyunOss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAliyunOss
@EnableDiscoveryClient
@SpringBootApplication
public class MallThirdPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallThirdPartyApplication.class, args);
	}

}
