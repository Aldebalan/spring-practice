package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello") // 요청매핑
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2") // 요청매핑
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}
	
}
