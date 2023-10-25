<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
	1. 폼 값을 받기
	2.DAO연동을 통해서 update메서드를 호출해서 회원 정보 수정 //update메서드
	3.매개변수의 값은 VO로 전당
	4. 수정 성공시, "회원 정보가 수정 되었습니다." 출력후 마이페이지로 이동 (단, user_name세션 변경)
	      수정 실패시, "회원 정보가 수정에 실패했습니다." 출력후 마이페이지로 이동
	*/
	if(session.getAttribute("user_id") ==null){
			response.sendRedirect("login.jsp");
		}
	
	
	request.setCharacterEncoding("utf-8");
	String id =(String)session.getAttribute("user_id");
	String name =(String)request.getParameter("name");
	String email =(String)request.getParameter("email");
	String address =(String)request.getParameter("address");
	
	UserDAO dao =UserDAO.getInstance();
	UserVO vo = new UserVO(id, null, name, email, address, null);
	
	
	int result =dao.update(vo);
	
	 if(result==1){// 성공	     
		session.setAttribute("user_name", name); //이름이 변경된 겨우 세션에서도 변경처리
		%> 
		<script>
		alert("회원정보가 수정 되었습니다.");
		location.href="mypage.jsp";
		</script>
		
   <% }else{ // 실패%> 
    	<script>
		alert("회원 정보가 수정에 실패했습니다.");
		location.href="mypage.jsp";
		</script>
   <% }%>    
	
	

	
	
    
    
    
