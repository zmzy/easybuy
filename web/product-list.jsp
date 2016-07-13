<%--
  Created by IntelliJ IDEA.
  User: SDUST-132
  Date: 2016/7/11
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网 - 首页</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" /></div>
    <div class="help"><a href="#" class="shopping">购物车</a><a href="login.html">登录</a><a href="register.html">注册</a><a href="guestbook.jsp">留言</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <li class="current"><a href="#">首页</a></li>
            <li><a href="#">图书</a></li>
            <li><a href="#">百货</a></li>
            <li><a href="#">品牌</a></li>
            <li><a href="#">促销</a></li>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="wrap">
        <ul class="clearfix">
            <li class="first"><a href="#">音乐</a></li>
            <li><a href="#">影视</a></li>
            <li><a href="#">少儿</a></li>
            <li><a href="#">动漫</a></li>
            <li><a href="#">小说</a></li>
            <li><a href="#">外语</a></li>
            <li><a href="#">数码相机</a></li>
            <li><a href="#">笔记本</a></li>
            <li><a href="#">羽绒服</a></li>
            <li><a href="#">秋冬靴</a></li>
            <li><a href="#">运动鞋</a></li>
            <li><a href="#">美容护肤</a></li>
            <li><a href="#">家纺用品</a></li>
            <li><a href="#">婴幼奶粉</a></li>
            <li><a href="#">饰品</a></li>
            <li class="last"><a href="#">Investor Relations</a></li>
        </ul>
    </div>
</div>
<div id="position" class="wrap">
    您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list.html">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
    <jsp:include page="include/left.jsp" />
    <div class="main">
        <div class="product-list">
            <h2>全部商品</h2>
            <div class="pager">
                <ul class="clearfix">
                    <input type="text" size="5" id="toPage" /><button onclick="goPage()">GO</button>
                    <select onselect="setPageSize()">
                        <option value="4">==显示条数==</option>
                        <option value="4">4</option>
                        <option value="8">8</option>
                        <option value="10">10</option>
                    </select>
                    <li><a href="/pro.do?action=list&pageIndex=1">首页</a></li>
                    <c:if test="${pageIndex>1}"><li><a href="/pro.do?action=list&pageIndex=${pageIndex-1}">上一页</a></li></c:if>
                    <c:forEach var="page" begin="1" end="${totalPage}">
                        <li><a href="/pro.do?action=list&pageIndex=${page}">${page}</a></li>
                    </c:forEach>
                    <c:if test="${pageIndex<totalPage}"><li><a href="/pro.do?action=list&pageIndex=${pageIndex+1}">下一页</a></li></c:if>
                    <li><a href="/pro.do?action=list&pageIndex=${totalPage}">末页</a></li>
                </ul>
            </div>
            <div class="clear"></div>
            <ul class="product clearfix">
                <c:forEach var="pro" items="${productList}">
                <li>
                    <dl>
                        <dt><a href="/pro.do?id=${pro.epId}&action=detail" target="_blank"><img src="${pro.epFileName}" /></a></dt>
                        <dd class="title"><a href="/pro.do?id=${pro.epId}&action=detail" target="_blank">${pro.epName}</a></dd>
                        <dd class="price">￥${pro.epPrice}</dd>
                    </dl>
                </li>
                </c:forEach>
            </ul>
            <div class="clear"></div>
            <div class="pager">
                <ul class="clearfix">
                    <input type="text" size="5" id="toPage" /><button onclick="goPage()">GO</button>
                    <select onselect="setPageSize()">
                        <option value="4">==显示条数==</option>
                        <option value="4">4</option>
                        <option value="8">8</option>
                        <option value="10">10</option>
                    </select>
                    <li><a href="/pro.do?action=list&pageIndex=1">首页</a></li>
                    <c:if test="${pageIndex>1}"><li><a href="/pro.do?action=list&pageIndex=${pageIndex-1}">上一页</a></li></c:if>
                    <c:forEach var="page" begin="1" end="${totalPage}">
                        <li><a href="/pro.do?action=list&pageIndex=${page}">${page}</a></li>
                    </c:forEach>
                    <c:if test="${pageIndex<totalPage}"><li><a href="/pro.do?action=list&pageIndex=${pageIndex+1}">下一页</a></li></c:if>
                    <li><a href="/pro.do?action=list&pageIndex=${totalPage}">末页</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
