package com.ddu.formtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
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

		if (mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);
			model.addAttribute("mid", mid);
			return "loginOk";
		} else {
			model.addAttribute("mid", mid);
			return "loginFail";
		}
	}
}
