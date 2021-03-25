<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sUserId = (String)session.getAttribute("sUserId");
	User sUser = (User)session.getAttribute("sUser");
%>    			
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<%if(sUserId!=null && sUser!=null){ %>
		<li><a href="user_view.do?userId=<%=sUserId%>"><%=sUser.getName()%>님</a></li>
		<li><a href="user_logout_action.do">로그아웃</a></li>
		<li><a href='user_list.do'>회원리스트</a>
	<%}else{ %>	
		<li><a href="user_login_form.do">로그인</a></li>
		<li><a href="user_write_form.do">회원가입</a></li>
	<%} %>	
</ul>
