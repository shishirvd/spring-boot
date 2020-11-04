package org.svd.microsvc.events;

import org.springframework.context.ApplicationEvent;

public class MyCustomEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3279819769482420361L;
	
	private String status;

	public MyCustomEvent(Object source,String status) {
		super(source);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
