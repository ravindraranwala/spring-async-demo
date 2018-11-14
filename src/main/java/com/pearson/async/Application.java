package com.pearson.async;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Executor taskExecutor() {
		// ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// executor.setCorePoolSize(2);
		// executor.setMaxPoolSize(2);
		// executor.setQueueCapacity(500);
		// executor.setThreadNamePrefix("GithubLookup-");
		// executor.initialize();
		// return executor;
		return Executors.newFixedThreadPool(2);
	}
}
