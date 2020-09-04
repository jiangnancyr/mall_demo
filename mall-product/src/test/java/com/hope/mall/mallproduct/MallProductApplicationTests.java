package com.hope.mall.mallproduct;

import com.hope.mall.mallproduct.entity.BrandEntity;
import com.hope.mall.mallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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

}
