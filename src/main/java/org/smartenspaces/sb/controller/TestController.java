package org.smartenspaces.sb.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/")
	@ResponseBody 
	public String test() throws IOException {
		return "Hello Docker world!";
	}
}
