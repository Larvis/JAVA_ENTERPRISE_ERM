<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
    <head>
        <title>Решение квадратного уравнения и суммы</title>
    </head>
    <body>
        <img src="img/img1.jpg" alt="alt"/>
        <form action="Main" method="POST">
            Решение квадратного уравнения и суммы:<br /><br />
            Введите A: <input type="text" name="a" /> <br />
            Введите B: <input type="text" name="b"/> <br />
            Введите C: <input type="text" name="c"/><br /> 
            Введите D: <input type="text" name="x"/><br /> <br /> 
            <input type="submit" name="calcQE" value="Решить квадратное уравнение" /> <br />
            <input type="submit" name="calcSum" value="Найти сумму всех цифр" /> <br /><br />
            <input type="button" id="random" value="Заполнить случайно" /> <br />
            <input type="reset" name="clear" value="Очистить" />
        </form>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script>
            jQuery('#random').on('click', function() {
                jQuery('[name="a"]').val(Math.floor(Math.random() * 10));
                jQuery('[name="b"]').val(Math.floor(Math.random() * 10));
                jQuery('[name="c"]').val(Math.floor(Math.random() * 10));
                jQuery('[name="x"]').val(Math.floor(Math.random() * 10));
            });
        </script> 
    </body>
</html>