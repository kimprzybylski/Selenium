package be.pxl.product.servlet;

import be.pxl.product.domain.Product;
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
@WebServlet("/doCreateProduct")
public class DoCreateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DoCreateProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get all parameters from the request to create a product
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        // store the product
        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setPrice(price);

        ProductService service = new ProductService();
        try {
            service.insertProduct(product);
        } catch (SQLException e) {
            request.getRequestDispatcher("/WEB-INF/view/createProductView.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            request.getRequestDispatcher("/WEB-INF/view/createProductView.jsp").forward(request, response);
        }
        // if an error occurs show the error on the page you came from
        // if no error occurred and the product was stored, show the list of products

        response.sendRedirect("productList");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}