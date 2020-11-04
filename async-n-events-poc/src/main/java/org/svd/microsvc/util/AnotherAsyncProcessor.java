package org.svd.microsvc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.svd.microsvc.events.MyEventPublisher;

@Component
public class AnotherAsyncProcessor {

	@Autowired
	private MyEventPublisher myEventPublisher;

	//@Async("threadPoolTaskExecutor")
	@Async
	public void process(String code) {
	    System.out.println("Execute method asynchronously. " 
	      + Thread.currentThread().getName() + " processing -> "+code);
	    myEventPublisher.publishCustomEvent("PROCESSING");
	}
}
