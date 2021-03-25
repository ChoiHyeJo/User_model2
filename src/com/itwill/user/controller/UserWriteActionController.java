package com.itwill.user.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;
import com.itwill.user.exception.ExistedUserException;

public class UserWriteActionController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:/WEB-INF/views/user_write_form.jsp";
			return forwardPath;
		}else {
			User newUser=null;
		try{
			request.setCharacterEncoding("UTF-8");
		    String userId=request.getParameter("userId");
		    String password=request.getParameter("password");
		    String name=request.getParameter("name");
		    String email=request.getParameter("email");
		    newUser=new User(userId,password,name,email);
		    UserService userService=new UserServiceImpl();
		    int rowCount = userService.create(newUser);
		    forwardPath="redirect:user_login_form.do";
	    }catch(ExistedUserException e){
	    	//아이디중복예외
	    	
	    	/****************************************************/
	    	
	    	/*************case2[forward]**************/
	    	request.setAttribute("msg", e.getMessage());
	    	request.setAttribute("fuser", newUser);
	    	//RequestDispatcher rd=request.getRequestDispatcher("user_write_form.jsp");
	    	//rd.forward(request, response);
	    	//<jsp:forward page="user_write_form.jsp"/>
	    	forwardPath="forward:/WEB-INF/views/user_write_form.jsp";
	    	//forwardPath="forward:user_write_form.do";
	    	/******************************************/
	    	
	    }catch(Exception e){
	    	//알수없는예외
	    	e.printStackTrace();
	    	forwardPath="forward:user_error.do";
	    	}
		}
		return forwardPath;
	}
}
