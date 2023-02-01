package com.example.product_discount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discountPercent = Float.parseFloat(request.getParameter("discount-percent"));

        float discountAmount = (float) (price*discountPercent*0.01);
        float discountPrice = price - discountAmount;

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<h1>description: "+description+"</h1>");
        writer.println("<h1>price: "+price+"</h1>");
        writer.println("<h1>discountPercent: "+discountPercent+"</h1>");
        writer.println("<h1>Discount Amount: "+discountAmount+"</h1>");
        writer.println("<h1>Discount Price: "+discountPrice+"</h1>");
        writer.println("</html>");
    }
}
