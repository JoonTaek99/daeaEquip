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

tr:nth-child(odd) {
    background-color: #f2f2f2;
}
</style>


</head>
<body>
    <h2>주전산장비사양관리대장</h2>
    <div class="search-container">
   	 	<form action="searchData.board" method="get">
       	 	<input type="text" name="keyword" id="searchInput" placeholder="검색어를 입력하세요">
        	<button type="submit">검색</button>
    	</form>
	</div>

    
   <div id="container">
    <table border="1">
        <tr>
            <th>용도</th>
            <th>자산번호</th>
            <th>운영자</th>
            <th>제조업체</th>
            <th>IP</th>
            <th>도입일자</th>
            <th>상세보기</th> <!-- 수정된 부분 -->
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
                        <td>${dto.purpose}</td>
                        <td>${dto.assetNumber}</td>
                        <td>${dto.operator}</td>
                        <td>${dto.manufacturer}</td>
                        <td>${dto.IP}</td>
                        <td>${dto.introductionDate}</td>
                        <td>
                            <form action="detailData.board" method="post">
                                <input type="hidden" name="assetNumber" value="${dto.assetNumber}">
                                <button type="submit">상세보기</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
    <tr>
	    <td colspan="10" style="text-align: center;">
	        <a href="boardList.board?pnum=${pMap.prePageNum}">◀</a>
	        <c:forEach begin="${pMap.startPage}" end="${pMap.endPage}" var="i" step="1">
	            <a ${(sessionScope.pnum == i or param.pnum == i)?"class='active'":""}  href="boardList.board?pnum=${i}">${i}</a>&nbsp;&nbsp;
	        </c:forEach>
	        <a href="boardList.board?pnum=${pMap.nextPageNum}">▶</a>
	    </td>
	</tr>
    </table>
</div>
   
   <!-- 장비 추가 버튼 -->
   <form action="insertDataForm.board" method="post">
       <button type="submit">장비 추가</button>
   </form>
   
</body>
</html>