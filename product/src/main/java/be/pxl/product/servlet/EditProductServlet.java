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
@WebServlet(value = "/editProduct")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get all parameters from the request
            String code = request.getParameter("code");
            Product product = new Product();
            product.setCode(code);

        ProductService service = new ProductService();
        try {
            service.findProduct(code);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            response.sendRedirect("productList");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            response.sendRedirect("productList");
        }


        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.



        // Store errorString in request attribute, before forward to views.


        // Logined, forward to /WEB-INF/views/editProductView.jsp
        request.setAttribute("product", product);
        request.getRequestDispatcher("WEB-INF/views/editProductView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}
