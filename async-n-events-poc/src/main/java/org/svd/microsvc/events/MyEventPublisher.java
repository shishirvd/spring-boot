package org.svd.microsvc.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyEventPublisher {

	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
 
    public void publishCustomEvent(final String message) {
        System.out.println("Inside Publisher. Publishing custom event :  "+message);
        MyCustomEvent customSpringEvent = new MyCustomEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
