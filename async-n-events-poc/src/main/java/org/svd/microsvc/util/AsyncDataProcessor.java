package org.svd.microsvc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.svd.microsvc.events.MyEventPublisher;

@Component
public class AsyncDataProcessor {
	
	@Autowired
	private MyEventPublisher myEventPublisher;

	//@Async("threadPoolTaskExecutor")
	@Async
	public void process(String code) {
	    System.out.println("Execute method asynchronously. " 
	      + Thread.currentThread().getName() + " argument -> "+code);
	    myEventPublisher.publishCustomEvent("INITIATED");
	}
}
