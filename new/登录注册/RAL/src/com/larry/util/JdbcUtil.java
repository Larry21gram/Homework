package com.larry.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

    private static String url;
    private static String user;
    private static String password;


    static {
        try {

            ClassLoader cl =
                    JdbcUtil.class.getClassLoader();

            InputStream inputStream =
                    cl.getResourceAsStream("jdbc.properties");

            Properties prop = new Properties();
            prop.load(inputStream);

            String driverName =prop.getProperty("driverName");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
