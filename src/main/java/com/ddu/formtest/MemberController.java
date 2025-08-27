package com.ddu.formtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest requset, Model model) {
		return "login";
	}
	@RequestMapping(value = "/login2")
	public String login2(HttpServletRequest requset, Model model) {
		return "login2";
	}
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest requset, Model model, HttpSession session, HttpServletResponse response) {
		// 기존 방식(세션에 저장 하거나 값이 적을 때 사용 권장)
		String mid = requset.getParameter("mid");
		String mpw = requset.getParameter("mpw");
		if (mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);
			model.addAttribute("mid", mid);
			return "loginOk";
		} else {
			model.addAttribute("mid", mid);
			return "loginFail";
		}
	}
	@RequestMapping(value = "/loginOk2")
	public String loginOk2(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpSession session, HttpServletResponse response) {
		// anotaion을 사용하며 파라미터 값 가져오기(가져올 값이 별로 없을 때 사용 권장)
		if (mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);
			model.addAttribute("mid", mid);
			return "loginOk";
		} else {
			model.addAttribute("mid", mid);
			return "loginFail";
		}
	}@RequestMapping(value = "/boardList/{bnum}")
	public String boardList(@PathVariable String bnum, Model model) { 
		// 파라미터 이름 없이 전달된 값 받아오기(가져올 값이 1개 밖에 없을 때 사용 권장)
		model.addAttribute("bnum",bnum);
		
		return "boardList";
	}
	@RequestMapping(value = "/join")
	public String join(HttpServletRequest requset, Model model) {
		return "join";
	}
	
	// 기존 방식
//	@RequestMapping(value = "/joinOk")
//	public String joinOk(HttpServletRequest requset, Model model) {
//		
//		String mid = requset.getParameter("mid");
//		String mpw = requset.getParameter("mpw");
//		String mname = requset.getParameter("mname");
//		String mage = requset.getParameter("mage");
//		
//		MemberDto memberDto = new MemberDto(mid, mpw, mname, mage);
//		
//		model.addAttribute("memberDto" , memberDto);
//		
//		return "joinOk";
//	}
	// model 방식
	@RequestMapping(value = "/joinOk" , method = RequestMethod.POST)
	public String joinOk(MemberDto memberDto, Model model) {
		// memberDto의 변수이름과 form의 파라미터 이름값이 정확히 일치해야함(모든 값을 다 받아야 할때 사용 권장)
		model.addAttribute("memberDto" , memberDto);
		
		return "joinOk";
	}
	@RequestMapping(value = "/joinOk" , method = RequestMethod.GET)
	public String joinOk2(MemberDto memberDto, Model model) {
		// memberDto의 변수이름과 form의 파라미터 이름값이 정확히 일치해야함(모든 값을 다 받아야 할때 사용 권장)
		model.addAttribute("memberDto" , memberDto);
		
		return "joinOk";
	}
	@RequestMapping(value = "/student" , method = RequestMethod.GET)
	public String studentOk(@ModelAttribute("sInfo") StudentInfo studentInfo, Model model) {
		// modelAtturibute로 변수이름을 만들어줌 
		
		//model.addAttribute("studentInfo" , studentInfo);
		
		return "studentOk";
	}
}
