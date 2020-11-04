package org.svd.microsvc.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyCustomEvent> {

	@Override
	public void onApplicationEvent(MyCustomEvent event) {
		System.out.println("Inside Event Listener.Event generated with status: " + event.getStatus());
		
	}

}
