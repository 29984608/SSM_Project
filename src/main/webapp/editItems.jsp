<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/4/26
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>商品信息修改页面</title>
</head>
<body>
<form action="" method="post">
    <table width="100%" border="1">
        <tr>
            <td colspan="2"> 修改商品信息</td>
        </tr>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${itemsCustom.name}"></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${itemsCustom.price}"></td>
        </tr>
<%--        <tr>
            <td>商品生成日期</td>
            <td><input type="text" name="createtime" value="${itemsCustom.createtime}"></td>
        </tr>--%>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${itemsCustom.detail}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="button" value="提交    ">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
