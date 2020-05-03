package com.example.helloworldapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class HelloWorldApiApplication {
	@Value("${eureka.instance.instanceId}")
	String instanceId;
	@Autowired
	HelloClient client;

	@RequestMapping("/")
	public String home() {
		return "Hello World from " + instanceId;
	}

	@RequestMapping("/reply")
	public String reply() {
		return client.reply();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApiApplication.class, args);
	}

	@FeignClient("hello-world-client")
	interface HelloClient {
		@RequestMapping(value = "/reply", method = RequestMethod.GET)
		String reply();
	}
}
