<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>My HTML2 View</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
</head>
<body>
<div class="success">
	<h3>views/html2 foo: "${foo}"</h3>
	<h3>views/html2 fruit: "${fruit}"</h3>
</div>
</body>
</html>