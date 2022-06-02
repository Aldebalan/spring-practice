package com.douzone.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello") // 요청매핑
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2") // 요청매핑
	public String hello2(String name) {		// String
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}
	
	@RequestMapping("/hello3") // 요청매핑
	public ModelAndView hello3(String name) {	// ModelAndView
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}
	
	@RequestMapping("/hello4") // 요청매핑
	public String hello4(String name, Model model) {	// 그냥 객체 (String도 MAV도 아님)
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello4.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello5") // 요청매핑
	public String hello5() {	// String 전송 (html코드 먹힘)
		return "<h1>hello world5</h1>";
	}
	
	@RequestMapping("/hello6") // 요청매핑
	public String hello6() {	// Redirecting
		return "redirect:/hello";
	}
	
	/* 비추천 > 기술비침투 전력 위배 */
	@RequestMapping("/hello7") // 요청매핑
	public void hello7(int no, 
		HttpServletRequest requset,
		HttpServletResponse response,
		HttpSession session,
		Writer pw) throws IOException {
		pw.write("<h1>hello world7</h1>");
	}
}
