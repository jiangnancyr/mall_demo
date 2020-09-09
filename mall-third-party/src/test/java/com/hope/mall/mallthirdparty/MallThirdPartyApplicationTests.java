package com.hope.mall.mallthirdparty;

import com.aliyun.oss.OSSClient;
import com.kuisama.oss.properties.AliyunOssProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class MallThirdPartyApplicationTests {

	@Autowired
	private AliyunOssProperties aliyunOssProperties;
	@Autowired
	private OSSClient ossClient;
	@Test
	void contextLoads() throws FileNotFoundException {
		InputStream inputStream = new FileInputStream("C:\\Users\\WangChuan\\Pictures\\lena1.jpg");

		ossClient.putObject("mall-hope","len.jpg",inputStream);

		ossClient.shutdown();

		System.out.println("上传完成功");
	}

}
