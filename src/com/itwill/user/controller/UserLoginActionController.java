package com.itwill.user.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

public class UserLoginActionController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="forward:/WEB-INF/views/user_login_action.jsp";
			return forwardPath;
		}else {
		String userId =null;
		String password=null;
		try{
			userId = request.getParameter("userId");
			password=request.getParameter("password");
			UserService userService=new UserServiceImpl();
			User loginUser = userService.login(userId,password);
			
			HttpSession session = request.getSession();
			session.setAttribute("sUserId", userId);
			session.setAttribute("sUser", loginUser);
			forwardPath="redirect:user_main.do";
		}catch(UserNotFoundException e){
			forwardPath="forward:/WEB-INF/views/user_login_form.jsp";
		}catch(PasswordMismatchException e){
			forwardPath="forward:/WEB-INF/views/user_login_form.jsp";
		}catch(Exception e){
		
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
		}
	}
}
