<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%if(session.getAttribute("user_id") ==null){
		response.sendRedirect("login.jsp");
	} %>
    
    <%@ include file ="/include/index_header.jsp" %>
    <section>
    	<div align="center">
    		<form action="delete_check_ok.jsp" method="post">
    			<h3>현재 비밀번호를 입력하세요.</h3>
    			<hr>
    			비밀번호 : <input type="password" name="pw"><br>
    			<input type="submit" value="확인">
    		</form>
    	</div>
    </section>
    
    <%@ include file ="/include/index_footer.jsp" %>
