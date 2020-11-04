<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/10/4
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
        <%--表明是第一个对象的username age--%>
            <input type="text" name="userList[0].username"> <br/>
            <input type="text" name="userList[0].age"> <br/>
            <input type="text" name="userList[1].username"> <br/>
            <input type="text" name="userList[1].age"> <br/>
            <input type="submit" value="提交">
    </form>
</body>
</html>
