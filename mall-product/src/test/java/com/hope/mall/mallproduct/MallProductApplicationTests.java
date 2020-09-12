package com.hope.mall.mallproduct;

import com.hope.mall.mallproduct.entity.BrandEntity;
import com.hope.mall.mallproduct.service.BrandService;
import com.hope.mall.mallproduct.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class MallProductApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	BrandService brandService;
	@Test
	public void serviceTest(){
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setName("华为");
		brandService.save(brandEntity);
		System.out.println("保存成功...");
	}
//	@Autowired
//	private AliyunOssProperties aliyunOssProperties;
//	@Autowired
//	private OSSClient ossClient;
//	@Test
//	public void uploadFile() throws FileNotFoundException {
//		try {
//			InputStream inputStream = new FileInputStream("C:\\Users\\WangChuan\\Pictures\\lena1.jpg");
//			String url = AliyunOssHandler.upload(ossClient, aliyunOssProperties, "len1.jpg", inputStream);
//			System.out.println(url);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	@Autowired
	CategoryService categoryService;
	@Test
	public void test_findPath(){
		Long[] catelogPath = categoryService.findCatelogPath(225L);
		log.info("完整路径：{}", Arrays.asList(catelogPath));

	}

}
