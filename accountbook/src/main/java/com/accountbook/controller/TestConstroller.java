package com.accountbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestConstroller {
	
	@GetMapping(value = "/{name}")
	public String test(@PathVariable String name) {
		return name;
	}
}
