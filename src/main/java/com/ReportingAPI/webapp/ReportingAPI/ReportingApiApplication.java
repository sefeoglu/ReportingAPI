package com.ReportingAPI.webapp.ReportingAPI;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;


@SpringBootApplication
public class ReportingApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(ReportingApiApplication.class, args);
	}

   

}
