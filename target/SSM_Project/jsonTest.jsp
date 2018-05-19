<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/5/19
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#button").click(function () {
                $.ajax({
                    type:'post',
                    url:'/json/jsonTest.action',
                    data:'{"username":"张三","sex":"男"}',
                    contentType:'application/json;charset=utf-8',
                    success:function (data) {
                        $("#content").append('username'+data.username+'<br>'+'sex'+data.sex);
                    }
                });
            });
        });
    </script>
</head>
<body>
<input type="button" value="点击提交" id="button">
<div id="content"></div>
</body>
</html>
