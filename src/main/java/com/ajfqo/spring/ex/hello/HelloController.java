package com.ajfqo.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody	// 리턴할 내용이 Response의 Body에 담기게 해주는 어노테이션
	@RequestMapping("/hello")	// url 매핑을 위한 어노테이션
	public String hello() {
		return "Hello World!!!";
	}
	
	
	
}
