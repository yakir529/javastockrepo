package com.myorg.javacourse.yakirproject;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.String;

@SuppressWarnings("serial")
public class MathServlet extends HttpServlet
{
              public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
              {
                             int num1 = 4;
                             int num2 = 3;
                             int num3 = 7;
                  int result = (num1 + num2) * num3;

                             String resultStr = new String("The result --> (" + num1 + "+" + num2 + ")*" + num3 + "=" + result);
                             
                             resp.setContentType("text/html");
                             
                             resp.getWriter().println(resultStr);

              }             
}
