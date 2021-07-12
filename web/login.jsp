<%--
  Created by IntelliJ IDEA.
  User: lwy
  Date: 2021/6/16
  Time: 上午8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<!DOCTYPE html>
<html>
<head>
    <title>用户登陆</title>
</head>
<style>
    body{
        text-align:center;
        background: url("image/17.jpg") fixed center center no-repeat;
        background-size: cover;
        width: 100%;
    }
    #center{
        margin:0 auto;
        border:1px soild #000;
        width:300px;
        height:300px
    }
    *{
        padding: 0;
        margin: 0;
    }
    .black_half{
        padding: 25px;
        background-color: rgba(0,0,0,0.5);
    }
    .black_half h1{
        color: #FFFFFF;
    }
    .black_half a{
        text-decoration:none;
        color: #FFFFFF;
    }
    .black_half a:hover{
        text-decoration:underline;
        color: #FFFFFF;
    }
    .white h3{
        color: #FFFFFF;
    }
</style>
<script>
    function validateLogin() {
        var userName = document.frmLogin.username.value;
        var password = document.frmLogin.password.value;
        if ((userName == "") || (userName == "输入您的用户名")) {
            alert("请输入用户名!");
            return false;
        }
        if ((password == "") || (password == "输入您的密码")) {
            alert("请输入密码!");
            return false;
        }
    }
</script>
<body>
<div align="center"><font face="宋体" size="6"><strong>
    <div id = "center">
        <form action="login.action" method="post" name="frmLogin">
            <table class="hovertable" >
                <tr>
                    <td colspan="5" align="center" style="font-size:30px;height: 80px;width:300px;"><strong>登陆</strong></td>
                </tr>
                <tr>
                    <th style="font-size:15px;">用户名：</th>
                    <td style="font-size:15px;"><input type="text" name="username" value="输入您的用户名"
                                                       maxlength="16" style="width:200px;"
                                                       onfocus="if(this.value == '输入您的用户名') this.value =''"></td>
                </tr>
                <tr>
                    <th style="font-size:15px;">密  码：</th>
                    <td style="font-size:15px;"><input type="text" name="password" value="输入您的密码"
                                                       maxlength="20" style="width:200px;"
                                                       onfocus="if(this.value == '输入您的密码'){this.value =''; this.type='password'}"></td>
                </tr>
                <tr>
                    <td colspan="5" align="center" style="font-size:15px;">
                        <input type="submit" value=" 登  录  ">
                        <input type ="button" value=" 新用户注册  " onclick="location='register.jsp'">
                    </td>
                </tr>
                <tr>
                    <td colspan="5" align="center"><a href="index.jsp">
                        返 回 主 页 </a></td>
                </tr>
            </table>
        </form>
    </div>
</strong>
</font>
</div>>
</body>
</html>
