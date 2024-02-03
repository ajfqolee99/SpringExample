package com.ajfqo.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lifecycle/ex02")
	// ResponseBody 어노테이션이 없음
	// ResponseBody가 있냐 없냐에 따라서
	// return된 내용이 그대로 Response에 담아지느냐 
	// jsp 경로를 통해서 jsp 수행결과로 만들어진 html을 Response에 담느냐
	public String ex02View() {
		// application.properties에서 설정해둔 경로로 간단해짐.
		return "lifecycle/ex02";
	}
	
	
}
