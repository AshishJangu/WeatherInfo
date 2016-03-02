<%-- 
    Document   : Disp.jsp
    Created on : Mar 1, 2016, 10:51:58 PM
    Author     : JANGU29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
String description;
String name;

String location;
String country;
double lat;
double lon;
String sunrise;
String sunset;
String temp;
String maxtemp;
String mintemp;
String pressure;
String humidity;

String windspeed;
String winddegree;

%>
    <%

   
  name=session.getAttribute("name").toString();
 description=session.getAttribute("description").toString();

   location=session.getAttribute("location").toString();
 country=session.getAttribute("country").toString();
   lat=(Double)session.getAttribute("lat");

   lon=(Double)session.getAttribute("lon");
   sunrise=session.getAttribute("sunrise").toString();
    sunset=session.getAttribute("sunset").toString();

   temp=session.getAttribute("temp").toString();
    maxtemp=session.getAttribute("maxtemp").toString();  
    mintemp=session.getAttribute("mintemp").toString();
   pressure=session.getAttribute("pressure").toString();
     humidity=session.getAttribute("humidity").toString();
     windspeed=session.getAttribute("windspeed").toString();
      winddegree=session.getAttribute("winddegree").toString();
   
     
   
%>
  
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Disp.css"/>
    <%--
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>
   
 
    
function initialize() {
   
  var mapProp = {
    center:new google.maps.LatLng(123,49),
    zoom:5,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
google.maps.event.addDomListener(window, 'load', initialize);
</script> --%>
</head>

<body>
    <jsp:include page="header.html"></jsp:include>
  
    <div id="info">
       <table id="t1" cellspacing="25" cellpadding="5">
           <tr> 
               <td>LOCATION: </td>                   
               <td><%=location%></td>
           </tr>
           <tr> 
               <td>COUNTRY: </td>                  
               <td><%=country%></td>
           </tr>
           <tr> 
               <td>LATITUDE: </td>                   
               <td><%=lat%></td>
           </tr>
           <tr> 
               <td>LONGITUDE: </td>                   
               <td><%=lon%></td>
           </tr>
           <tr> 
               <td>SUNRISE: </td>                   
               <td><%=sunrise%></td>
           </tr>
           </table>
          <table id="t2"cellspacing="25" cellpadding="5">
           <tr> 
               <td>SUNSET: </td>                   
               <td><%=sunset%></td>
           </tr>
           <tr> 
               <td>TEMPERATURE: </td>                  
               <td><%=temp%></td>
           </tr>
           <tr> 
               <td>MAX-TEMP: </td>                   
               <td><%=maxtemp%></td>
           </tr>
           <tr> 
               <td>MIN-TEMP: </td>                   
               <td><%=mintemp%></td>
           </tr>
           <tr> 
               <td>PRESSURE: </td>                   
               <td><%=pressure%></td>
           </tr>
           </table>
          <table id="t3" cellspacing="25" cellpadding="5" >
           <tr > 
               <td>HUMIDITY: </td>                   
               <td><%=humidity%></td>
           </tr>
           <tr> 
               <td>WIND SPEED: </td>                  
               <td><%=windspeed%></td>
           </tr>
     <tr> 
               <td>NAME: </td>                  
               <td><%=name%></td>
           </tr>
            <tr> 
               <td>DESCRIPTION: </td>                  
               <td><%=description%></td>
           </tr>
        
           </table>
           
        

  </div>
        
        
        
        
    
 <jsp:include page="Footer.html"></jsp:include>
</body>

</html>