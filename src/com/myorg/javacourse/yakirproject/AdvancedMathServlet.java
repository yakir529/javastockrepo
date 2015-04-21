package com.myorg.javacourse.yakirproject;

import java.io.IOException;
import java.lang.Math;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class AdvancedMathServlet extends HttpServlet
{
              protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
              {             
                             resp.setContentType("text/html");
                             
                             String firstLine;
                             int radius = 50;
                             double area = (radius*radius) * Math.PI;
                             firstLine = new String("The area of the circle with radius " + radius + " is: " +area+ " square-cm");
                             
                             String secondLine;
                             float secondAngle = 30;
                             float hypotenuse = 50;
                             double opposite = hypotenuse * Math.sin(Math.toRadians(secondAngle));
                             secondLine = new String("The Length of opposite where the second angle is 30 degrees and Hypotenuse length is 50 cm is: " +opposite+ "cm");
                             
                             String thirdLine;
                             int base = 20;
                             int exp = 13;
                             long powerResult = (long)Math.pow(base,exp);
                             thirdLine = new String("Power of 20 with exp of 13 is: " +powerResult);
                             
                             String resultStr = firstLine + "<br>" + secondLine + "<br>" + thirdLine;
                             resp.getWriter().println(resultStr);                                  
              }             
}
