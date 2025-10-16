package org.freshwerehouse.persistance.dao;

import java.sql.SQLException;
import java.util.List;
import org.freshwerehouse.persistance.entity.User;

public interface UserDAO {
    List<User> getAllUsers() throws SQLException;

    void addUser(int id, String name, String email, String password, String position) throws SQLException;

    void updateUser(int id, String name, String email,String password, String position) throws SQLException;

    void deleteUser(int id) throws SQLException;

    User getUserById(int id) throws SQLException;

}
