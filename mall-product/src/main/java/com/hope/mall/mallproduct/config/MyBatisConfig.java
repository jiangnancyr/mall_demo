package com.hope.mall.mallproduct.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author cyrcreate
 * @create 2020-09-12 0:03
 */


@Configuration
@EnableTransactionManagement
@MapperScan("com.hope.mall.mallproduct.dao")
public class MyBatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        paginationInterceptor.setOverflow(true);

        paginationInterceptor.setLimit(1000);

        return paginationInterceptor;
    }
}
