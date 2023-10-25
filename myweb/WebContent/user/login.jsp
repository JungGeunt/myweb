<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%if(session.getAttribute("user_id") != null){
		response.sendRedirect("/user/mapage.jsp");
	} %>
<!DOCTYPE html>
	<body>
		<%@ include file ="/include/index_header.jsp" %>
	
	
	
	<section>
		<div align="center">
			<h2>로그인 페이지</h2>
			<hr>
			<form action="login_ok.jsp" method="post">
				<input type="text" name="id" placeholder="아이디"><br>
				<input type="password" name="pw" placeholder="비밀번호"><br>
				<br>
				<input type="submit" value="로그인" class="bnt bnt-default">
				<input type="button" value="회원가입" class="bnt bnt-primary" onclick="location.href='join.jsp'">
			</form>
		</div>
	</section>
	
	<%@ include file="/include/index_footer.jsp" %>
	</body>
</html>