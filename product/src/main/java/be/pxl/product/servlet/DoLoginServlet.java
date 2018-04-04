package be.pxl.product.servlet;

import be.pxl.product.dao.DAOUtil;
import be.pxl.product.domain.UserAccount;
import be.pxl.product.service.ProductService;
import be.pxl.product.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(value = "/doLogin")
public class DoLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DoLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get all parameters from the request
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");

        // for the "Remember me" field, use ServletUtil class

        ProductService service = new ProductService();

        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;

        try {
            user = service.findUser(userName, passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // test is username and password are not null and string lengths are > 0
        if (user.getUserName() == null && user.getUserName().length() > 0) {
            hasError = true;
            errorString = "U moet een userName ingeven";
        } if (user.getPassword() == null && user.getPassword().length() > 0) {
            hasError = true;
            errorString = "U moet een paswoord ingeven";
        }


        // If error, forward to /WEB-INF/views/login.jsp
        if (hasError == true) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        } else {
            UserAccount account = new UserAccount();
            account.setUserName(userName);
            account.setPassword(passWord);

            HttpSession session = request.getSession(true);
            ServletUtil.storeLoginedUser(session, account);

            response.sendRedirect("UserInfo");
        }


        // If no error
        // Store user information in Session, use ServletUtil class
        // And redirect to userInfo page.

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // stay out here!

        doGet(request, response);
    }

}