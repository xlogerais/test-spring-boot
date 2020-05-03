package com.example.helloworldapi2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class HelloWorldApiApplication {
	@Autowired
	HelloClient client;

	@RequestMapping("/")
	public String home() {
		return client.hello();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApiApplication.class, args);
	}

	@FeignClient("hello-world-api")
	interface HelloClient {
		@RequestMapping(value = "/", method = RequestMethod.GET)
		String hello();
	}
}
