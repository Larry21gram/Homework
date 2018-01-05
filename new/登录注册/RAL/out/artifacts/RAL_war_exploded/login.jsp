<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/4
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        body{
            background-color: lightgray;
        }
        input::-moz-placeholder { /* Mozilla Firefox 19+ */
            color: gold;
        }
        input{
            width: 270px;
            height: 42px;
            margin-top: 25px;
            padding: 0 15px;
            background: #ef4300;
            border-radius: 6px;
            border: 1px solid #ff730e;
            font-size: 14px;
        }
        span,button{
            width: 300px;
            height: 44px;
            margin-top: 25px;
            padding: 0;
            background: #ef4300;
            border-radius: 6px;
            border: 1px solid #ff730e;
            font-size: 20px;
            font-weight: 700;
            color: honeydew;

        }
        #div1{
            height: 200px;
            background-image: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514907133449&di=16d6dbd61cd39175872121d5bf2644f3&imgtype=0&src=http%3A%2F%2Fp4.image.hiapk.com%2Fuploads%2Fallimg%2F141011%2F7730-141011144418.jpg");
        }
        #div2{
            text-align: center;

        }

    </style>
</head>
<body>
<div id="div1">
    <h1>用户名：${param.userName}</h1>
</div>
<div id="div2">
    <h1 style="color: orangered ; font-size: 60px">login</h1>
    <form action="/login" method="post">
        <input name="username" type="text"
            <%
                     Object userName = application.getAttribute("userName");
                if (userName !=null){
                    String uname = (String) userName;
                    %>
               placeholder="<%= uname %>"
            <%
                }else {
                             %>
               placeholder="请输入用户名"
            <%
                }
             %>
               class="username">
        <br><br>
        <input name="password" type="password" placeholder="请输入密码" class="password">
        <br><br>
        <button type="submit">Sign me in</button>
        <br><br>
        <span >
            <a href="register.html" style="font-size: 28px">register</a>
        </span>
    </form>


</div>
</body>
</html>
