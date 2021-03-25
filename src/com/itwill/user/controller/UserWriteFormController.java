package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserWriteFormController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) {
	     String forwardPath="forward:/WEB-INF/views/user_write_form.jsp";
	     return forwardPath;
	}
}
