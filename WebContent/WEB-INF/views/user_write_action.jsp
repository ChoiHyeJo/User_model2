<%@page import="com.itwill.user.UserServiceImpl"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.exception.ExistedUserException"%>
<%@page import="com.itwill.user.UserService"%>
<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_write_form.jsp");
		return;
	}
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
	    response.sendRedirect("user_login_form.jsp");
    }catch(ExistedUserException e){
    	//아이디중복예외
    	
    	/*************************case1[redirect]**************/
    	response.sendRedirect("user_write_form.jsp?msg="+URLEncoder.encode(e.getMessage(),"UTF-8"));
    	/****************************************************/
    	
    	/*************case2[forward]**************
    	request.setAttribute("msg", e.getMessage());
    	request.setAttribute("fuser", newUser);
    	RequestDispatcher rd=request.getRequestDispatcher("user_write_form.jsp");
    	rd.forward(request, response);
    	//<jsp:forward page="user_write_form.jsp"/>
    	******************************************/
    	
    }catch(Exception e){
    	//알수없는예외
    	e.printStackTrace();
    	response.sendRedirect("user_error.jsp");
    }
%>















