<%-- 
    Document   : index.jsp
    Created on : Mar 1, 2016, 4:20:13 PM
    Author     : JANGU29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
  session=request.getSession();
 
%>
<html>
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"  href="main.css"/>
    
    </head>
    
    <body>
        <jsp:include page="header.html"></jsp:include>
        <div  id="login" style=" display:inline-table;height:60%;width:40%;margin-top:200px;margin-left:350px;"> 
            <pre>
        <form id="weatherInfo"  method="get" action="Parser">
            <center>
            ENTER PLACE          <input type="text" name="city" autocomplete="on"/>
                    
           
                            
            ENTER COUNTRY       <input type="text" name="country" autocomplete="on"/>
                             
                <input type="submit"/>
</center>        </form>
            </pre>
       
        </div>
        <jsp:include page="Footer.html"></jsp:include>
    </body>
</html>

