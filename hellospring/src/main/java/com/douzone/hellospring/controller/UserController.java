package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequestMapping url + RequestMethod 매핑
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(UserVo vo) { // 객체로 받음 > UserVo의 setter에 의해 값이 무조건 세팅된다
		System.out.println(vo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/*
		 * 만일 n이라는 이름의 파라미터가 없는 경우 400 Bad Request 에러가 발생한다.
		 */
		return "UserController.update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2( // null처리를 defaultValue로 지정해줌
		@RequestParam(value="n", required=true, defaultValue="") String name,
		@RequestParam(value="a", required=true, defaultValue="0") int age) {
		return "UserController.update(" + name + ":" + age + ")";
	}
	
}
