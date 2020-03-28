package com.anurag.mybatiscrud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("${mbg.target-package.mapper}")
public class MybatiscrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatiscrudApplication.class, args);
	}

}
