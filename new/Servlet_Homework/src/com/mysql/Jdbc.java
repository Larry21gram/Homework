package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    获得连接
    public static Connection getConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/servlet";
        Connection connection = DriverManager.getConnection(url, "root", "123");
        return connection;
    }
}
