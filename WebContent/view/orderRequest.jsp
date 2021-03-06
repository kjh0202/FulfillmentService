<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="Resources/css/bootstrap.min.css" rel="stylesheet">
<title>Fulfillment Service</title>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../common/navigator.jsp"/>
	
			<div class="col-sm-9 col-md-10  main">
			 	<h3>발주 요청</h3>
				<hr>
				<strong>&lt; 발주 요청중인 것들 &gt;</strong><br>
				<%-- var="ea" items="${eListAmount}" --%>
				<c:set var="eListId" value="${requestScope.eListId}"/>
				<c:set var="eListAmount" value="${requestScope.eListAmount}"/>
				<c:forEach var="ei" items="${eListId}" varStatus="status">
					물품id: ${ei.event_pId}&nbsp;&nbsp;요청개수: ${eListAmount[status.index].event_pAmount}개<br>
				</c:forEach>
				<br>
			 	<div class="col-ms-11" >
				 	<table class="table table-hover">
		  				<tr>
		  					<th>물품 id</th>
		  					<th>물품 이름</th>
		  					<th>물품 가격</th>
		  					<th>재고량</th>
		  					<th>구매처 아이디</th>
		  					<th>구매처 이름</th>
		  					<th>발주 요청</th>
		  				</tr>
		  				<c:set var="pList" value="${requestScope.pList}"/>
						<c:forEach var="p" items="${pList}">
							<c:choose>
							<c:when test="${p.pAmount > 10}">
			  					<tr>
			  						<td>${p.pId}</td>
				  					<td>${p.pName}</td>
				  					<td>${p.pPrice}</td>
				  					<td>${p.pAmount}</td>
				  					<td>${p.p_oId}</td>
				  					<td>${p.p_oName}</td>
				  					<td>
				  					<form name="form1" action="/FulfillmentService/ProductProc?action=requestItemsDetail&pId=${p.pId}" method="POST">
					   					<input type="submit" value="GO" name="submit" class="btn btn-info" />
									</form>
				  					</td>
			  					</tr>
		  					</c:when>
		  					<c:otherwise>
		  						<tr style="color:red">
			  						<td>${p.pId}</td>
				  					<td>${p.pName}</td>
				  					<td>${p.pPrice}</td>
				  					<td>${p.pAmount}</td>
				  					<td>${p.p_oId}</td>
				  					<td>${p.p_oName}</td>
				  					<td>
				  					<form name="form1" action="/FulfillmentService/ProductProc?action=requestItemsDetail&pId=${p.pId}" method="POST">
					   					<input type="submit" value="GO" name="submit" class="btn btn-info" />
									</form>
				  					</td>
			  					</tr>
		  					</c:otherwise>
		  					</c:choose>
		  				</c:forEach>
					</table>
					<hr><hr>
		 		</div>
		 	</div>
 		</div>
	</div>
 
<jsp:include page="../common/footer.jsp" />

<!-- ==================================================================== -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="Resources/js/bootstrap.min.js"></script>


</body>
</html>