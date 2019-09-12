package com.idosinchuk.reactiveprogramming.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Enable eureka client. It inherits from @EnableDiscoveryClient.
@EnableEurekaClient
//This annotation enables feign client.
@EnableFeignClients("com.idosinchuk.reactiveprogramming.feign")

@SpringBootApplication
public class ReactiveProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingApplication.class, args);
	}

}
