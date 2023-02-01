package com.example.javawebcurrencyconverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConverterServlet", value = "/Convert")
public class ConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float vnd = rate*usd;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>"+rate+"</h1>");
        writer.println("<h1>"+usd+"</h1>");
        writer.println("<h1>"+vnd+"</h1>");
        writer.println("</html>");
    }
}
