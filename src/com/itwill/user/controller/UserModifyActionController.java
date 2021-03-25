package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserModifyActionController implements Controller{
	 @Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		 String forwardPath=""; 
		 if(request.getMethod().equalsIgnoreCase("GET")){
			  	forwardPath="forward:/WEB-INF/views/user_main.jsp";
				return forwardPath;
			}else {
			try{
				request.setCharacterEncoding("UTF-8");
				String userId=request.getParameter("userId");
				String password=request.getParameter("password");
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				UserService userService=new UserServiceImpl();
				int row = userService.update(new User(userId,password,name,email));
				forwardPath="redirect:user_view.do?userId="+userId;
			}catch(Exception e){
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/user_error.jsp";
			}
		}
		return forwardPath;
	 }
}
