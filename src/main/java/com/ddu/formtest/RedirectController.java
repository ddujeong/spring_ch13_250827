package com.ddu.formtest;


import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {
	@RequestMapping(value = "/studentInput")
	public String studentInput() {
		return "studentInput";
		
	}
	@RequestMapping(value = "/studentCheck")
	public String studentCheck(@RequestParam("sid") String sid, Model model, HttpServletResponse response) {
		
		if(sid.equals("tiger")) {
			// 학생이면 studentGood 으로 이동 아니면 studentNg로 이동
			return "redirect:studentGood"; // ->REDIRECT를 사용해야만 model에 실어보낸 객체를 받을 수 있음 (~~.do)
			//return "studentGood"; // redirect를 사용 하지 않으면 객체를 받지 못함(~~.jsp)
		} else {
			return "redirect:studentNg"; // ->REDIRECT를 사용해야만 model에 실어보낸 객체를 받을 수 있음
			//return "studentNg"; // redirect를 사용 하지 않으면 객체를 받지 못함
		}
		
	}
	@RequestMapping(value = "/studentGood")
	public String studentGood(Model model) {
		model.addAttribute("sid", "tiger");
		return "studentGood";
		
	}
	@RequestMapping(value = "/studentNg")
	public String studentNg(Model model) {
		model.addAttribute("sid", "tiger");
		return "studentNg";
		
	}
	
}
