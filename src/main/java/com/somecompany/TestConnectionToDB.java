package com.somecompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionToDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
