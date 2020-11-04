package org.svd.microsvc.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class MyAsyncConfiguration implements AsyncConfigurer{
	
	/*
	 * 
	This is to override Async behavior at a method level.
	
	@Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
    
    */
	
	@Override
	@Bean(name = "threadPoolTaskExecutor")
    public Executor getAsyncExecutor() {
        return new ThreadPoolTaskExecutor();
    }

}
