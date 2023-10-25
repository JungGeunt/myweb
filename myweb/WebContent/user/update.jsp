<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	/*
    	이 페이지에 들어 왔을때 , getUserInfo()메서드를 재활용하여 정보를 불러온 후에 
    	아래의 태그에 정보가 노출되게처리... id태그는 바꿀 수 없게 처리...
  		*/
    	//URL 강제 접근 차단
  		if(session.getAttribute("user_id") ==null){
  			response.sendRedirect("login.jsp");
  		}
    
    	String id = (String)session.getAttribute("user_id");
    	
    	UserDAO dao = UserDAO.getInstance();
    	UserVO vo =dao.getUserInfo(id);
    	
    	
    
    %>
  
    <%@ include file ="/include/index_header.jsp" %>

	<section>
	
			<div align="center">
				<form  name="updform" action="update_ok.jsp" method="post">
				 <h2>회원정보 수정 페이지</h2>
				 	<table>
				 		<tr>
				 		<td>아이디 </td>
							<td><input type="text" name="id" value="<%=vo.getId() %>" readonly></td>
						</tr>
						<tr>
							<td>이름 </td>
							<td><input type="text" name="name"  value="<%=vo.getName() %>"></td>
						</tr>
						<tr>
							<td>이메일 </td>
							<td><input type="email" name="email" value="<%=vo.getEmail()%>" ></td>
						</tr>
						<tr>
							<td>주소 </td>
							<td><input type="text" name="address" value="<%=vo.getAddress() %>"></td>
				 		</tr>
				 	</table>
				 	<br><br>
					<input type="button" value="정보수정" class="btn btn-primary" onclick="check()">
					<input type="button" value="마이페이지" class="btn btn-info" onclick="location.href='mypage.jsp'">
				</form>
			</div>
	</section>
	
	<script>
		function check() {
			//form은 유일하게 document.태그이름.태그이름으로 하위태그에 대한 접근이 가능하다.
			//check()는 회원 가입 창에 각 값들에 대한 검증을 위해서 사용하는 함수
			if(document.updform.id.value === ''){
				alert('이름은 필수 사항입니다.');
				return;
			}else if(confirm('회원 정보 업데이트를 하시겠습니까?')){
				//confirm()은 확인창에 "예" 혹은 "확인"시 true , "아니오 , 취소"를 선택시 false
				document.updform.submit(); //자바스트립트의submit()
			}
				
		}
	</script>



	<%@ include file ="/include/index_footer.jsp" %>
