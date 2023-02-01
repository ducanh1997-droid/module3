package com.example.simple_dictionary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();

        dictionary.put("hello","xin chào");
        dictionary.put("how","thế nào");
        dictionary.put("book","quyển vở");
        dictionary.put("computer","máy tính");

        String search = request.getParameter("txtSearch");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if(result != null){
            writer.println("Word: "+search);
            writer.println("Result: "+result);
        }else{
            writer.println("Not found");
        }
        writer.println("</html>");

    }
}
