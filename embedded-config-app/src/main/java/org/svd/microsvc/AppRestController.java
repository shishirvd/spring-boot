package org.svd.microsvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RefreshScope
public class AppRestController {

	@Value("${message}")
	private String message;
	
	@Value("${newmessage}")
	private String newmessage;
	
	@Value("${commonmessage}")
	private String commonmessage;
	
	@GetMapping()
	public String getMessage() {
		return message+newmessage+commonmessage  ;
	}
}
