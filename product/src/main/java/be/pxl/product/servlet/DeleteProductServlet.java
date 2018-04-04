package be.pxl.product.servlet;

import be.pxl.product.dao.DAOUtil;
import be.pxl.product.service.ProductService;
import be.pxl.product.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@WebServlet(value = "/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get product code to delete for deleting product
        String code = request.getParameter("code");

        ProductService service = new ProductService();
        try {
            service.deleteProduct(code);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Het product is niet verwijderd");
            request.getRequestDispatcher("WEB-INF/views/deleteProductErrorView.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Het product is niet verwijderd");
            request.getRequestDispatcher("WEB-INF/views/deleteProductErrorView.jsp").forward(request, response);
        }
        // if an exception is thrown handle it carefully using "errorString" to notify error on view
        // if no exception is thrown show your product list
        response.sendRedirect("productList");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}