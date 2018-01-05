<%@ page import="com.larry.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.larry.domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>用户名：<span id="username"></span></h1>

<button id="btn" >退出</button>

<br>
<%
    User user = (User) request.getSession().getAttribute("user");
     if (user.getUsername()!= null){

%>
        <table border="1">
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>价格</th>
            </tr>
<%

         //表示已经登录
//         获得书本信息
         List<Book> books = (List<Book>) session.getAttribute("books");

//         遍历书本
         for (Book book : books) {

    %>
           <tr>
               <td>
                   <a href="<%=book.getUrl()%>">
                       <%=book.getName()%>
                   </a>
               </td>

               <td><%=book.getWriter()%></td>
               <td><%=book.getPrice()%></td>
           </tr>

    <%

         }
    %>
        </table>
    <%
     }else {
//         转到登录
         request.getRequestDispatcher("/login.html").forward(request,response);
     }
%>

</body>
<script type="text/javascript">
    $.getJSON("http://localhost:8080/show",
        function (json,status) {
            if(status == "success"){
                $('#username').text(json['username']);
            }
        })

</script>
</html>
