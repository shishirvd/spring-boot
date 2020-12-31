package org.svd.microsvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.svd.microsvc.util.AsyncDataProcessor;

@RestController
@PreAuthorize("hasAuthority('ROLE_USER')")
public class MyServicesController {
	
	@Autowired
	private AsyncDataProcessor asyncDataProcessor;

	@GetMapping("/hello")
	public String hello() {

		asyncDataProcessor.process("step1");
		return "Hello!! How are you?";
	}
}
