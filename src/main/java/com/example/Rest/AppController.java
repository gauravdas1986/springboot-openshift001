package com.example.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class AppController {

	@GetMapping("/done")
	public String getMethod(){
		return "Well Done Mr. G!!!";
	}
}
