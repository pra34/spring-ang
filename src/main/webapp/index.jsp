<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Test Example</title>  
     <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />" ></link>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
<!-- apply our angular app to our site -->
<body ng-app="myApp">

<!-- navigation -->
<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" ui-sref="index">Angular UI-Router</a>
    </div>
    <ul class="nav navbar-nav">
        <li><a ui-sref="index">Home</a></li>
    </ul>
</nav>

<!-- main view -->
<div class="container">

    <div ui-view></div>

</div>

</body>

<script src="<c:url value='/static/lib/angular.min.js' />"></script>
<script src="<c:url value='/static/lib/angular-ui-router.min.js' />"></script>
<script src="<c:url value='/static/javascript/app.js' />"></script>
<script src="<c:url value='/static/javascript/service/user_service.js' />"></script>
<script src="<c:url value='/static/javascript/controller/user_controller.js' />"></script>
<script src="<c:url value='/static/javascript/controller/user_edit_controller.js' />"></script>

 </html>