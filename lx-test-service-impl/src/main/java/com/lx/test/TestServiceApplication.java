package com.lx.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 项目启动入口
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.lx.test", "com.lx.pk.dubbo"})
@ImportResource({"classpath:applicationContext.xml"})
public class TestServiceApplication {
    public static void main(String args[]) {
        SpringApplication.run(TestServiceApplication.class, args);
        System.err.println("启动成功");
    }
}
