<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/10/4
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script>
        var userList = new Array();
        userList.push({username:"zhangsan", age: 18});
        userList.push({username:"lisi", age: 28});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/quick15",
            data:JSON.stringify(userList),
            contentType:"application/json; charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
