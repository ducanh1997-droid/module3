package com.example.product_manager.controller;

import com.example.product_manager.model.Category;
import com.example.product_manager.model.Product;
import com.example.product_manager.service.impl.CategoryService;
import com.example.product_manager.service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//annotation @WebServlet: dùng để đánh dấu đây là 1 Servlet, được quản lý bới ServletContainer
//name: đặt tên cho Servlet để quản lý
//value hoặc urlPattern: dùng để định danh đường dẫn cho Servlet
@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    //tạo đối tượng Service để thao tác với cấu trúc dữ liệu lưu đối tượng
    private  final CategoryService categoryService = new CategoryService();
    private final ProductService productService;

    public ProductServlet() {
        productService = new ProductService(categoryService);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request parameter Action: nhằm quy định về hành động đang đang yêu cầu của client
        String action = request.getParameter("action");
        String object = request.getParameter("object");
        //tránh lỗi khi không có parameter Action đi kèm
        if (action == null) {
            action = "";
        }

        //dùng câu lệnh điều kiện để điều hướng Action tương ứng về với phương thức tương ứng
        switch (action) {
            case "display":
                displayCategoryList(request,response);
                break;
            case "create":
                switch (object){
                    case "product":
                        createProduct(request,response);
                        break;
                    case "category":
                        createCategory(request,response);
                        break;
                }
                break;
            case "delete":
                switch (object){
                    case "product":
                        deleteProduct(request, response);
                        break;
                    case "category":
                        deleteCategory(request,response);
                        break;
                }
                break;

            case "detail":
                detailProduct(request, response);
                break;
            case "update":
                switch (object){
                    case "product":
                        updateFormProduct(request,response);
                        break;
                    case "category":
                        updateFormCategory(request,response);
                        break;
                }
                break;
            default:
                displayProductList(request, response);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
        request.setAttribute("categories", categoryService.findAll());
        rd.forward(request, response);
    }
    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("category/create.jsp");
        request.setAttribute("category", categoryService.findAll());
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //tương tự ở doGet, có thể tách phương thức đoạn code này để tái sử dụng
        String action = request.getParameter("action");
        String object = request.getParameter("object");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                switch (object){
                    case "product":
                        createP(request, response);
                        break;
                    case "category":
                        createC(request, response);
                        break;
                }
                break;
            case "update":
                switch (object){
                    case "product":
                        updateP(request, response);
                        break;
                    case "category":
                        updateC(request, response);
                        break;
                }
                break;
            default:
                displayProductList(request, response);
        }
    }

    //hiển thị tất cả sản phẩm
    private void displayProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
        request.setAttribute("products", productService.findAll());
        rd.forward(request, response);
    }

    private void displayCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("category/list.jsp");
        request.setAttribute("categories", categoryService.findAll());
        rd.forward(request, response);
    }
    //hiển thị chi tiết 1 sản phẩm
    private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
        request.setAttribute("product", productService.findById(id));
        rd.forward(request, response);
    }

    //mở form update với giá trị thuộc tính của sản phẩm tương ứng
    private void updateFormProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
        request.setAttribute("categories", categoryService.findAll());
        request.setAttribute("product", productService.findById(id));
        rd.forward(request, response);
    }
    private void updateFormCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        RequestDispatcher rd = request.getRequestDispatcher("category/update.jsp");
        request.setAttribute("category", categoryService.findById(id));
        rd.forward(request, response);
    }

    //nhận dữ liệu của tạo mới
    private void createP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String category = request.getParameter("category");
        productService.save(new Product(name, price, quantity,categoryService.returnCategory(category)));
        //xử lý lỗi duplicate dữ liệu trong khi tạo hoặc sửa: điều hướng với Servlet tương ứng
        response.sendRedirect("/products");
    }
    private void createC(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        categoryService.save(new Category(name));
        //xử lý lỗi duplicate dữ liệu trong khi tạo hoặc sửa: điều hướng với Servlet tương ứng
        RequestDispatcher rd = request.getRequestDispatcher("category/list.jsp");
        request.setAttribute("categories", categoryService.findAll());
        rd.forward(request, response);
    }


    //nhận dữ liệu của chỉnh sửa thông tin sản phẩm theo id
    private void updateP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String category = request.getParameter("category");
        productService.update(new Product(id,name, price, quantity,categoryService.returnCategory(category)));
        response.sendRedirect("/products");
    }

    private void updateC(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        categoryService.update(new Category(id,name));
        RequestDispatcher rd = request.getRequestDispatcher("category/list.jsp");
        request.setAttribute("categories", categoryService.findAll());
        rd.forward(request, response);
    }
    //xóa sản phẩm theo id
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/products");
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));
        categoryService.delete(id);
        RequestDispatcher rd = request.getRequestDispatcher("category/list.jsp");
        request.setAttribute("categories", categoryService.findAll());
        rd.forward(request, response);
    }

}
