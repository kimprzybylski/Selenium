package be.pxl.product.servlet;

import be.pxl.product.dao.DAOUtil;
import be.pxl.product.domain.Product;
import be.pxl.product.service.ProductService;
import be.pxl.product.utils.ServletUtil;
import com.sun.xml.internal.fastinfoset.algorithm.IEEE754FloatingPointEncodingAlgorithm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@WebServlet(value = "/doEditProduct")
public class DoEditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DoEditProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get all parameters from the request
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));

        // update the product
        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setPrice(price);

        ProductService service = new ProductService();
        try {
            service.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/views/editProductView.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/views/editProductView.jsp").forward(request, response);
        }
        // on error return to the page you came from with the error
        // else show the product list containing the updated product

        response.sendRedirect("productList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}