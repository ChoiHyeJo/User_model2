<%@page import="com.itwill.user.UserServiceImpl"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>    
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	try{
		String userId=request.getParameter("userId");
		UserService userService=new UserServiceImpl();
		int row=userService.remove(userId);
		if(userId.equals(sUserId)){
			//로그인한사람일경우 로그아웃
			response.sendRedirect("user_logout_action.jsp");
		}else{
			response.sendRedirect("user_list.jsp");
		}		
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
%>