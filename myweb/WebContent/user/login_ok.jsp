<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
	request.setCharacterEncoding("utf-8");
    
    String id= request.getParameter("id");
    String pw= request.getParameter("pw");
    
    /*
    	1.DAO를 통해서 executeQuery()메서드를 이용한 결과값 존재 여부 확인
    	2.결과값이 이ㅆ다면, 성공으로 1을
    	결과 값이 없다면, 실패로 0을 반환
    	3.실패인 경우에는 경고창 출력한 후에 뒤로가기, 성공인 경우에는 mypage.jsp로이동 
    	세션을 포함
    */
    
    UserDAO dao = UserDAO.getInstance();
    
    int result = dao.login(id, pw);
    
    if(result == 1 ){//로그인 성공
    	//로그인 성공시 회원 정보를 얻어오는 작업
    	UserVO vo = dao.getUserInfo(id);
    	String name =vo.getName();
    	
    	//아이디와 이름을 세션에 넣기
    	session.setAttribute("user_id", id);
    	session.setAttribute("user_name", name);
    	
		%>
		<script>
		location.href="mypage.jsp";
		</script>
		
   <% }else{ //로그인 실패%> 
    	<script>
		alert("아이디 또는 비밀번호가 잘못되었습니다.");
		history.go(-1); //뒤로가기
		</script>
   <% }
    
    
    
    
    %>