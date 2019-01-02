<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--DEV --%>
<%
String appId = "3";
String userId = "3";
String account = "DEV";
%>
<script type="text/javascript">
/* js 全局变量 **********************************************************/
var $g_menuJson = [
	{"tc_code":"Category management","tc_order":"2-1","tc_app_id":3,"tc_permit_id":27,"pid":0,"id":1,"tc_name":"分类管理","tc_url":"/admin/category/query"},
	{"tc_code":"Model management","tc_order":"2-2","tc_app_id":3,"tc_permit_id":2,"pid":0,"id":2,"tc_name":"模型管理","tc_url":"/admin/model/query"},
	{"tc_code":"Image management","tc_order":"2-3","tc_app_id":3,"tc_permit_id":18,"pid":0,"id":14,"tc_name":"图片管理","tc_url":"/admin/image/query"},
	{"tc_code":"Test","tc_order":"2-4","tc_app_id":3,"tc_permit_id":0,"pid":0,"id":100,"tc_name":"测试","tc_url":"/admin/tbhd/query"}
	];
var $g_btnJson = null;
/************************************************************************/
$(function(){
	// nav
	$chok.nav.init($g_menuJson);
	// 导航菜单查询
	$("#navSearchForm").submit(function(event) {
		event.preventDefault();
	});
});
</script>
<%-- CAS
<%@ page import="chok.cas.client.CasLoginUser" %>
<%@ page import="chok.cas.client.filter.CasAccessFilter" %>
<%
CasLoginUser o = (CasLoginUser)session.getAttribute(CasAccessFilter.LOGINER);
String appId = o==null?"":o.getString("appId");
String userId = o==null?"":o.getString("id");
String account = o==null?"":o.getString("tc_code");
String menuJson = o==null?"":o.getString("menuJson");
String btnJson = o==null?"":o.getString("btnJson");
request.setAttribute("LoginUser", o);
%>
 --%>
<%-- SSO
<%@ page import="chok.sso.client.AuthUser"%>
<%@ page import="chok.sso.client.filter.LoginFilter"%>
<%
AuthUser o = (AuthUser)session.getAttribute(LoginFilter.LOGINER);
String appId = o==null?"":o.getString("appId");
String userId = o==null?"":o.getString("id");
String account = o==null?"":o.getString("tc_code");
String menuJson = o==null?"":o.getString("menuJson");
String btnJson = o==null?"":o.getString("btnJson");
request.setAttribute("LoginUser", o);
%>
--%>
<%-- 用于生产环境
<script type="text/javascript">
/* js 全局变量 **********************************************************/
var $g_menuJson = <%=menuJson%>;
var $g_btnJson = <%=btnJson%>;
/************************************************************************/
$(function(){
	// nav
	$chok.nav.init($g_menuJson);
	// 导航菜单查询
	$("#navSearchForm").submit(function(event) {
		event.preventDefault();
		var url = $("#navSearchForm").attr('action');
		$.post(
			url, 
			{'tc_name':$("#menuName").val(), "tc_user_id":<%=userId%>, "tc_app_id":<%=appId%>},
		  	function(rv) {
				$chok.nav.init(JSON.parse(rv));
			}
		);
	});
});
</script>
 --%>