<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(session.getAttribute("user_id") ==null){
	response.sendRedirect("login.jsp");
}

%>


<%@ include file="/include/index_header.jsp" %>

	<section>
		<div align="center">
			<h3>비밀번호 변경 페이지</h3>
 			<hr>
 	
 	<form action="change_pw_ok.jsp" method="post">
 		현재비밀번호: <input type="password" name="old_pw"><br>
 		변경비밀번호: <input type="password" name="new_pw"><br>
 		<input type="submit" value="확인">
 		<input type="button" value="취소" onclick="history.go(-1)">
 	</form>
		</div>
	</section>
	

<%@ include file="/include/index_footer.jsp" %>