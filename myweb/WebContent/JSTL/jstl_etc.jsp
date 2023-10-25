<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String test ="test";
%> 
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jstl.etc.jsp</title>
	</head>
	<body>
	
	<h2>remove 테스트</h2>
	<c:set var="test2" value="test2"></c:set>
		<c:remove var="test" scope="page"/>
		<%=test %><br>
		<c:set var="test" value="<%=test %>"></c:set>
		${test}<br>
		${test2 }<br>
		
	<h2>c:forTokens 테스트</h2> <!-- 토 -->
	<!-- 자바의 StringTokenizer를 JSRL를 사용하여 구현하려 할 때 쓸 수 있습니다. 	
		=>문자열을 구분자로 나눌때 , 사용함.-->
		<c:set var="tokens" value="안녕/하세요/지금은/JSP수업시간/입니다."/>
		<c:forTokens  var="abc" items="${tokens}" delims="/">
			${abc}<br>
		</c:forTokens>
	</body>
</html>