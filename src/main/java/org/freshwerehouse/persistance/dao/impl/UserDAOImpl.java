package org.freshwerehouse.persistance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.freshwerehouse.config.DatabaseConfig;
import org.freshwerehouse.persistance.dao.UserDAO;
import org.freshwerehouse.persistance.entity.User;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY id ASC LIMIT 30")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String position = rs.getString("position");
                String create_at = rs.getString("create_at");
                String update_at = rs.getString("update_at");
                Boolean isDriver = rs.getBoolean("isdriver");
                String phone = rs.getString("phone");
                String personalNumber = rs.getString("personalnumber");
                String categoryInTm = rs.getString("categoryintm");
                users.add(new User(id, name, email, password, position, create_at, update_at, isDriver, phone, personalNumber, categoryInTm));
            }
        }
        return users;
    }

    @Override
    public void addUser(int id, String name, String email, String password, String position) throws SQLException {
        String sql = "INSERT INTO users (id, name, email, password, position, create_at, update_at) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.setString(5, position);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void updateUser(int id, String name, String email, String password, String position) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?, password = ?, position = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, position);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public User getUserById(int id) throws SQLException {
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("position"), rs.getString("create_at"), rs.getString("update_at"), rs.getBoolean("isdriver"), rs.getString("phone"), rs.getString("personalnumber"), rs.getString("categoryintm"));
                }
            }
        }
        return null;
    }
}