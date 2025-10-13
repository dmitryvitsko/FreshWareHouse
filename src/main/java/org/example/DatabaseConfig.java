package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/warehouse_db?characterEncoding=UTF-8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "rvrt9ymkn9s2";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
