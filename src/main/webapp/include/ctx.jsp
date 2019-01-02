<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="chok.util.PropertiesUtil" %>
<%
String ctx = request.getContextPath();
String imagePath = PropertiesUtil.getValue("config/", "image.path");
request.setAttribute("ctx", ctx);
request.setAttribute("statics", ctx+"/static");
request.setAttribute("jspstatics", ctx+"/jspstatic");
request.setAttribute("imagePath", imagePath);
%>
<script type="text/javascript">
var $ctx="${ctx}";
</script>