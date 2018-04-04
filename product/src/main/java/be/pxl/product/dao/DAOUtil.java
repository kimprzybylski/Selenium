package be.pxl.product.dao;

import be.pxl.product.domain.Product;
import be.pxl.product.domain.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOUtil bean.
 */
public class DAOUtil {

    public static UserAccount findUser(String userName, String password) throws SQLException, ClassNotFoundException {

        Connection conn = MySQLConnUtils.getMySQLConnection();

        // create query, process resultset and return a user account!
        UserAccount account = null;
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE USER_NAME = ? AND PASSWORD = ?");
            statement.setString(1, userName);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    account = new UserAccount();
                    account.setUserName(resultSet.getString("USER_NAME"));
                    account.setGender(resultSet.getString("GENDER"));
                    account.setPassword(resultSet.getString("PASSWORD"));
                }
            }


        return account;
    }

    public static UserAccount findUser(String userName) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtils.getMySQLConnection();

        // create query, process resultset and return a user account!
        UserAccount account = null;
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE USER_NAME = ?");
        statement.setString(1, userName);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                account = new UserAccount();
                account.setUserName(resultSet.getString("USER_NAME"));
                account.setGender(resultSet.getString("GENDER"));
                account.setPassword(resultSet.getString("PASSWORD"));
            }
        }


        return account;
    }

    public static List<Product> queryProduct() throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        List<Product> products = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PRODUCT");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setCode(resultSet.getString("CODE"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getFloat("PRICE"));
                products.add(product);
            }
        }


        return products;
    }

    public static Product findProduct(String code) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        Product product = null;
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PRODUCT WHERE CODE = ?");
        statement.setString(1, code);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                product = new Product();
                product.setCode(resultSet.getString("CODE"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getFloat("PRICE"));
            }
        }
        return product;
    }

    public static void updateProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE PRODUCT SET NAME=?, PRICE=? WHERE CODE=?");
            stmt.setString(1, product.getName());
            stmt.setFloat(2, product.getPrice());
            stmt.setString(3, product.getCode());
            stmt.executeUpdate();
    }

    public static void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO PRODUCT (CODE, NAME, PRICE) VALUE (?,?,?)");
            statement.setString(1, product.getCode());
            statement.setString(2, product.getName());
            statement.setFloat(3, product.getPrice());
            statement.executeUpdate();

    }

    public static void deleteProduct(String code) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM PRODUCT WHERE CODE = ?");
            statement.setString(1, code);
            statement.executeUpdate();

    }
}
