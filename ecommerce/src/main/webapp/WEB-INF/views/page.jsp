<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop-Online - ${title}</title>


<script>
	window.menu = '${title}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min1.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myap.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<c:if test="${userClickHome == true}">
		<%@include file="home.jsp"%>
	</c:if>

	<!-- About Page -->
	<c:if test="${userClickAbout == true}">
		<%@include file="about.jsp"%>
	</c:if>

	<!-- Contact Page -->
	<c:if test="${userClickContact == true}">
		<%@include file="contact.jsp"%>
	</c:if>
	
	<!-- Contact Page -->
	<c:if test="${userClickProducts == true}">
		<%@include file="products.jsp"%>
	</c:if>

	<!-- FOOTER -->
	<%@include file="./shared/footer.jsp"%>

	<!-- jQuery -->
	<script src="${js}/jquery1.js"></script>

	<!-- Bootstrap core JavaScript -->
	<!-- <script src="vendor/jquery/jquery.min.js"></script> -->
	<script src="${js}/bootstrap.bundle.min.js"></script>
	<script src="${js}/myapp.js"></script>
</body>

</html>
