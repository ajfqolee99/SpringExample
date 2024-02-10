package com.ajfqo.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqo.spring.ex.jsp.service.UserService;

@Controller
@RequestMapping("/jsp/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 이름, 생년월일, 이메일을 전달받고, 저장하는 페이지
//	@RequestMapping("/jsp/user/create", method=RequestMethod.GET)
	@GetMapping("/create")
	@ResponseBody
	public String createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email) 
	{
		int count = userService.addUser(name, birthday, email);
		return "입력성공 : " + count;
	}
	
	// jsp 경로를 return
	// webapp아래 모든 경로
	// @ResponseBody어노테이션이 붙으면 경로로 인식하지 않고 순수한 문자열로 리턴한다.
	// 경로에 있는 jsp파일에 최종적으로 나온 html 결과물을 response에 담기위한 메소드를 만든것.
	@GetMapping("/input")
	public String inputUser() {
		//return "/WEB-INF/jsp/jsp/user-input.jsp";	application.properties에 공통되는 경로를 지정해주었기 때문에 공통부분 제외하고 경로작성
		return "/jsp/user-input";
		
	}
	
}
