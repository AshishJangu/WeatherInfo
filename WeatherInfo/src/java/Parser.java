/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.*;
import javax.json.stream.JsonParser;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.ws.rs.client.Entity.json;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.servlet.http.HttpSession;
import static javax.ws.rs.client.Entity.json;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


/**
 *
 * @author JANGU29
 */
public class Parser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession();
            double lon=0;
            double lat=0;
            String city=request.getParameter("city");
            
              String country=request.getParameter("country");
             
            /* TODO output your page here. You may use following sample code. */
              
              String urlString="";
             
              urlString="http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&appid=44db6a862fba0b067b1930da0d769e98";

           URL url=new URL(urlString);
           URLConnection con=url.openConnection();
           InputStream is=con.getInputStream();
           BufferedReader br=new BufferedReader(new InputStreamReader(is));
           String data="";
           String line;
           while((line=br.readLine())!=null)
           {
               
               data+=line;
           }
           out.println(data);
        JsonParser jp;
            jp = Json.createParser(new StringReader(data));
            while(jp.hasNext())
            {
                switch(jp.next())
                {
                  case START_OBJECT:
            {
                System.out.println("START_OBJECT");
                break;
            }
             case END_OBJECT:
            {
                 System.out.println("END_OBJECT");
                break;
            }
              case START_ARRAY:
            {
                 System.out.println("START_ARRAY");
                break;
            }
               case END_ARRAY:
            {
                 System.out.println("END_ARRAY");
                break;
            }
                case KEY_NAME:
            {
               // if(jp.getString().equals("lat"))
                 //   lat=jp.getInt();
                out.println(jp.getString()+":");
                 
                break;
            }
                
                 case VALUE_STRING:
            {
                  out.println(jp.getString()+"\n");
                
                break;
            }
                  case VALUE_NUMBER:
            {
                 out.println(jp.getInt()+"\n");

                break;
            }
                default:
            {
                   System.out.print("DEFAULT");

                break;
            }
                   
             
                }
            }
           JsonObject ob=Json.createReader(new StringReader(data)).readObject();
           
            String lat1=ob.getJsonObject("coord").get("lat").toString();
          lat=Double.parseDouble(lat1);
             String lon1=ob.getJsonObject("coord").get("lon").toString();
             
          lon=Double.parseDouble(lon1);
         String temp=ob.getJsonObject("main").get("temp").toString();
           String maxtemp=ob.getJsonObject("main").get("temp_max").toString();
             String mintemp=ob.getJsonObject("main").get("temp_min").toString();
             String pressure=ob.getJsonObject("main").get("pressure").toString();
             String humidity=ob.getJsonObject("main").get("humidity").toString();
             String visibility=ob.getJsonObject("main").get("humidity").toString();
                     String windspeed=ob.getJsonObject("wind").get("speed").toString();
                            String winddegree=ob.getJsonObject("wind").get("deg").toString();
                                String sunrise=ob.getJsonObject("sys").get("sunrise").toString();
                                 String sunset=ob.getJsonObject("sys").get("sunset").toString();
                                 String description=ob.getJsonArray("weather").getJsonObject(0).getString("description");
                                 String name=ob.get("name").toString();
                                // String visibility=ob.getJsonObject(temp).toString();
                                
           out.println("LONGITUDE--------------------------"+name+description);
        
           session.setAttribute("name",name);
           session.setAttribute("description",description);
           session.setAttribute("location",city);
           session.setAttribute("lat", lat);
             session.setAttribute("lon",lon);
             session.setAttribute("country",country);
            
             session.setAttribute("sunrise",sunrise);
           session.setAttribute("sunset",sunset);
             session.setAttribute("temp",temp);
             session.setAttribute("maxtemp",maxtemp);
              session.setAttribute("mintemp",mintemp);
           session.setAttribute("pressure",pressure);
             session.setAttribute("humidity",humidity);
             session.setAttribute("windspeed",windspeed);
                session.setAttribute("winddegree",winddegree);
             
             response.sendRedirect("Disp.jsp");
           
           // out.println(lat);
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Parser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Parser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
