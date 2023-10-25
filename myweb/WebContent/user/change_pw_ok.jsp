<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	1.폼값 처리
	2.login(id, 예전비밀번호 -old_pw) 아이디와 비밀번호가 맞는지 확인 -인증 
	 예전 비밀 번호가 틀린경우 뒤로가기 
	3.일치하면 changePassword(??) DAO 객체에 생성
	4.changePassword 메서드 실행 결과 
	성공하면, "비밀번호 변경 처리 되었습니다." 출력 후 mypage로 이동
	실패하면, "비밀번호 변경처리 실패했습니다." 출력 후 mypage로 이동
	
	*/
		 
	 request.setCharacterEncoding("utf-8");
	 String id =(String)session.getAttribute("user_id");
     String old_pw= request.getParameter("old_pw");
     String new_pw= request.getParameter("new_pw");
     
     UserDAO dao = UserDAO.getInstance();
     
     int result =dao.login(id,  old_pw);
     
    
	 
     if(result==1){// 인증 통과
    	int result2 = dao.changPassword(id, new_pw);
    	
    	 if(result2 == 1 ){%>
    			<script>
    			alert("비밀번호 변경처리 되었습니다.");
    			location.href="mypage.jsp";
    			</script>
    			
    	   <% }else{ //로그인 실패%> 
    	    	<script>
    			alert("비밀번호 변경처리 실패했습니다..");
    			location.href="mypage.jsp";
    			</script>
    	   <% }
    	    

     }else{%>//인증 통과x
    	 <script>
			 history.go(-1);
			</script>
     <% }

%>    
    
    