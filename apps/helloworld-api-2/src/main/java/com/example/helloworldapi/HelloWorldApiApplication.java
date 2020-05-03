package com.example.helloworldapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class HelloWorldApiApplication {
	@Value("${eureka.instance.instanceId}")
	String instanceId;

	@RequestMapping("/")
	public String home() {
		return "Hello World from " + instanceId;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApiApplication.class, args);
	}
}
