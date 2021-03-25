package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserRemoveActionController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		 String forwardPath="";
		 	HttpSession session = request.getSession();
		 	User user = (User)session.getAttribute("sUser");
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:/WEB-INF/views/user_main.jsp";
			}
			try{
				String userId=request.getParameter("userId");
				UserService userService=new UserServiceImpl();
				int row=userService.remove(userId);
				if(userId.equals(user.getUserId())){
					//로그인한사람일경우 로그아웃
					forwardPath="redirect:user_logout_action.do";
				}else{
					forwardPath="redirect:user_list.do";
				}		
			}catch(Exception e){
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/user_error.jsp";
			}
			return forwardPath;
	}
}
