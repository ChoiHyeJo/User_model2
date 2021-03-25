package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserViewController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		  String forwardPath="";
	  	String userId=request.getParameter("userId");
		if(userId==null||userId.equals("")){
			forwardPath="redirect:user_list.do";
		}
		UserService userService = null;
		try {
			userService = new UserServiceImpl();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			User user = userService.findUser(userId);
			
			if(user==null){
				forwardPath="redirect:user_list.do";
			}else {
				request.setAttribute("user", user);
				forwardPath="forward:/WEB-INF/views/user_view.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return forwardPath;
	}
}
