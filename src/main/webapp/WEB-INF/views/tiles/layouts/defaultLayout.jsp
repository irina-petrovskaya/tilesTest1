
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="mytitle"/></title>
    <link href="<c:url value='/static/css/app.css'/>" rel="stylesheet"></link>

</head>

<body>
<header id="header">
    <tiles:insertAttribute name="myheader" />
</header>

<section id="sidemenu">
    <tiles:insertAttribute name="mymenu" />
</section>

<section id="site-content">
    <tiles:insertAttribute name="mybody" />
</section>

<footer id="footer">
    <tiles:insertAttribute name="myfooter" />
</footer>
</body>
</html>