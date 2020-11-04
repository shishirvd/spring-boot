package org.svd.microsvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.svd.microsvc.util.AsyncDataProcessor;

@RestController
public class MyServicesController {
	
	@Autowired
	private AsyncDataProcessor asyncDataProcessor;

	@GetMapping("/hello")
	public String hello() {

		asyncDataProcessor.process("code");
		return "Hello!! How are you?";
	}
}
