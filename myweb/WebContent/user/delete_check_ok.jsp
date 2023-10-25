<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    /*
    1.폼값 처리
    2. login(id,pw) 메서드를 사용하여 인증 확인
    3. login메서드가 0인 경우 "비밀번호를 확인하세요" 출력후 마이페이지로 이동
       login메서드 결과가 1인경우 delete()를 실행
    4.삭제 성공시 ,  "회원 탈퇴 처리가 되었습니다."  출력. 세션을 전부 삭제.
    		홈 위치로 이동(/myweb)
             삭제 실패시,"회원 탈퇴에 실패 했습니다." 출력. 마이페이지로 이동
        
             sql= "delete from users where id =?"
    */
    if(session.getAttribute("user_id") ==null){
		response.sendRedirect("login.jsp");
	}
    
     request.setCharacterEncoding("utf-8");	
     String pw =request.getParameter("pw");
     String id =(String)session.getAttribute("user_id");
     
     UserDAO dao = UserDAO.getInstance();
     
     int result=dao.login(id, pw);
     
     
     if(result ==0){%>
    	<script>
		alert("비밀번호를 확인하세요.");
		location.href="mypage.jsp";
		</script>
    	 
    <% }else if(result==1){
    	 int result2 =dao.delete(id);
    	 
	    	 if(result2==1){
	    		 session.invalidate();
	    		 %>
	    	<script>
				alert("회원 탈퇴 처리가 되었습니다.");
				location.href="/myweb";
			</script>
	    <% }else{%>
    		<script>
	    		alert("회원 탈퇴에 실패 했습니다.");
	    		location.href="mypage.jsp";
    		</script>
	    	<% }
    	 
     } %>
    
    
    
