<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core 제어문</title>
</head>
<body>
	
	<h2>조건문, 반복문</h2>
	
	<h3>1. if else if</h3>
	<%-- 몸무게가 70이하면 치킨, 80이하면 샐러드, 그게 아니면 굶어 --%>
	<c:set var="weight" value="75" />
	
	<c:choose>
		<c:when test="${weight <= 70 }">
			<h4>치킨</h4>
		</c:when>
		<c:when test="${weight <= 80 }">
			<h4>샐러드</h4>
		</c:when>
		<c:otherwise>
			굶어
		</c:otherwise>
	</c:choose>
	
	
	<h3>2. 반복문</h3>
	<%-- for(int i = 0; i < 5; i++) {} --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i } 
	</c:forEach>
	
	<%-- for(String fruit:fruitList) {} 		반복상태를 확인할수 있는 변수 --%>
	<c:forEach var="fruit" items="${fruitList }" varStatus="status">
		<h4>${fruit }   ::   ${status.count } ${status.index } ${status.first } ${status.last }</h4>
	</c:forEach>
	
	
	
	
</body>
</html>