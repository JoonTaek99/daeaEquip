<%@page import="com.daea.dtos.EquiDto"%>
<%@page import="com.daea.daos.EquiDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>

<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th {
    background-color: #f2f2f2;
    padding: 8px;
    text-align: left;
}

td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}
</style>


</head>
<body>
    <h2>Board List</h2>
    
    <div class="search-container">
   	 	<form action="searchData.board" method="get">
       	 	<input type="text" name="keyword" id="searchInput" placeholder="검색어를 입력하세요">
        	<button type="submit">검색</button>
    	</form>
	</div>

    
   <div id="container">
   <table border="1">
           <tr>
               <th>아이디</th>
               <th>모델명</th>
               <th>제조업체</th>
               <th>관리자</th>
               <th>부서</th>
               <th>IP</th>
               <th>도입일자</th>
           </tr>
       		<c:set var="lists" value="${list}" />
       		<c:choose>
       			<c:when test="${empty lists}">
       				<tr>
       					<td colspan="10">--데이터가 없습니다.--</td>
       				</tr>
       			</c:when>
       			<c:otherwise>
       				<c:forEach items="${lists}" var="dto">
       					<tr>
       						<td>${dto.id}</td>
       						<td>${dto.model}</td>
       						<td>${dto.manufacturer}</td>
       						<td>${dto.operator}</td>
       						<td>${dto.department}</td>
       						<td>${dto.IP}</td>
       						<td>${dto.acqdate}</td>
       					</tr>
       				</c:forEach>
       			</c:otherwise>
       		</c:choose>
   </table>
   </div>
   
   <!-- 장비 추가 버튼 -->
   <form action="insertDataForm.board" method="post">
       <button type="submit">장비 추가</button>
   </form>
   
</body>
</html>
