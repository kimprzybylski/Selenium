package be.pxl.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by tomschuyten on 26/05/17.
 */
public class MySQLConnUtils {

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {

        // Note: Change the connection parameters accordingly.
        String hostName = "localhost";
        String dbName = "ProductDB";  // create this db before running db script
        String userName = "root";
        String password = "";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException,
            ClassNotFoundException {

        // Declare the class Driver for MySQL DB
        // This is necessary with Java 5 (or older)
        // Java6 (or newer) automatically find the appropriate driver.
        // If you use Java> 5, then this line is not needed.
        Class.forName("com.mysql.jdbc.Driver");


        // create URL Connection for MySQL
        String database  = "jdbc:mysql://"+ hostName + "/"+ dbName + "?serverTimezone=UTC";
        return DriverManager.getConnection(database, userName, password);
    }
}
