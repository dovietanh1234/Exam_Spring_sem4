package com.rs.test_springboot_sem4.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

    private static Connection connection = null;

    public static Connection getConnection(){
        if (connection != null){
            return connection;
        }else{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/demot2207a?useSSL=false";
            String user = "root";
            String password = "123456";

            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return connection;
    }

}
