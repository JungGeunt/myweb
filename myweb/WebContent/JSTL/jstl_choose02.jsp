<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 
		choose 절을 이용하여 A는 90점이상 ,Bsms 80 이상
		Csms 70점 이상 , 나머지는 F
		 -->
		<c:choose>
			<c:when test="${param.point >90 }">
			A 입니다.
			 	<c:choose>
			 		<c:when test="${param.point >= 100">
			 			S입니다.
			 		</c:when>
			 		<c:when test="${param.point >= 95">
			 			A+입니다.
			 		</c:when>
			 		<c:otherwise>
			 			A 입니다.
			 		</c:otherwise>
			 	</c:choose>
			</c:when>
			<c:when test="${param.point >80 }">
			B 입니다.
			</c:when>
			<c:when test="${param.point >70 }">
			C 입니다.
			</c:when>
			<c:otherwise>
			F 입니다.
			</c:otherwise>
		</c:choose>
	</body>
</html>