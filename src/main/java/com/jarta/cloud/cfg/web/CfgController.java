package com.jarta.cloud.cfg.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CfgController {
	
	@RequestMapping("/")
	public String index() {
		return "where am I";
	}
}
