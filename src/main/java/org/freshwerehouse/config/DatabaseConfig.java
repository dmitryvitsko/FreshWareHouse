package org.freshwerehouse.config;

import org.freshwerehouse.exception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.freshwerehouse.exception.Message.CONNECTION_DB_ERROR;

public class DatabaseConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/warehouse_db?characterEncoding=UTF-8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "rvrt9ymkn9s2";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new DatabaseException(String.format(CONNECTION_DB_ERROR, e.getMessage()));
        }
    }

}
