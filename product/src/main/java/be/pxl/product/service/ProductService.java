package be.pxl.product.service;

import be.pxl.product.dao.DAOUtil;
import be.pxl.product.domain.Product;
import be.pxl.product.domain.UserAccount;

import java.sql.SQLException;
import java.util.List;

/**
 * ProductService bean.
 */
public class ProductService {

    DAOUtil dao;

    public ProductService() {
        dao = new DAOUtil();
    }

    public UserAccount findUser(String userName, String password) throws SQLException, ClassNotFoundException {

        // make use of DAOUtil

        return dao.findUser(userName, password);
    }

    public UserAccount findUser(String userName) throws SQLException, ClassNotFoundException {

        // make use of DAOUtil

        return dao.findUser(userName);
    }

    public List<Product> queryProduct() throws SQLException, ClassNotFoundException {

        // make use of DAOUtil

        return dao.queryProduct();
    }

    public Product findProduct(String code) throws SQLException, ClassNotFoundException {

        // make use of DAOUtil

        return dao.findProduct(code);
    }

    public void updateProduct(Product product) throws SQLException, ClassNotFoundException {

        // make use of DAOUtil
        dao.updateProduct(product);
    }

    public void insertProduct(Product product) throws SQLException, ClassNotFoundException {

        // make use of DAOUtil
        dao.insertProduct(product);
    }

    public void deleteProduct(String code) throws SQLException, ClassNotFoundException {

        // make use of DAOUtil
        dao.deleteProduct(code);
    }
}