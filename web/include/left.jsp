<%--
  Created by IntelliJ IDEA.
  User: SDUST-132
  Date: 2016/7/12
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="lefter">
    <div class="box">
        <h2>商品分类</h2>
        <dl>
            <c:forEach var="ca" items="${categoryList}">
                <c:if test="${ca.epcParentId==0}">
                    <dt>${ca.epcname}</dt>
                </c:if>
                <c:forEach var="pca" items="${categoryList}">
                    <c:if test="${ca.epcId==pca.epcParentId}">
                        <dd><a href="/pro.do?action=list">${pca.epcname}</a></dd>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </dl>
    </div>
    <div class="spacer"></div>
    <div class="last-view">
        <h2>最近浏览</h2>
        <dl class="clearfix">
            <c:forEach var="recent" items="${recent}">
                <dt><img src="${recent.epFileName}" width="54px" height="54px"  /></dt>
                <dd><a href="/pro.do?id=${recent.epId}&action=detail">${recent.epName}</a></dd>
            </c:forEach>
        </dl>
    </div>
</div>
</body>
</html>
