package org.freshwerehouse.service;

import org.freshwerehouse.exception.DatabaseException;
import org.freshwerehouse.persistance.dao.UserDAO;
import org.freshwerehouse.persistance.entity.User;
import org.freshwerehouse.view.UserView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static org.freshwerehouse.exception.Message.*;

public class UserPresenterService {

    private UserDAO model;
    private UserView view;
    private Scanner scanner;

    public UserPresenterService(UserDAO model, UserView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void loadAndDisplayUsers() {
        try {
            List<User> users = model.getAllUsers();
            view.displayUsers(users);
        } catch (SQLException e) {
            throw new DatabaseException(CANNOT_DISPLAY_USERS);
        }
    }

    public void addUser() {
        try {
            System.out.print("Введите ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите email: ");
            String email = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();
            System.out.print("Введите позицию: ");
            String position = scanner.nextLine();
            model.addUser(id, name, email, password, position);
            System.out.println("Пользователь добавлен!");
            loadAndDisplayUsers();
        } catch (SQLException e) {
            throw new DatabaseException(CANNOT_ADD_USER);
        }
    }

    public void updateUser() {
        try {
            System.out.print("Введите ID пользователя для обновления: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите новое имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите новый email: ");
            String email = scanner.nextLine();
            System.out.print("Введите новый пароль: ");
            String password = scanner.nextLine();
            System.out.print("Введите новую должноть: ");
            String position = scanner.nextLine();
            model.updateUser(id, name, email, password, position);
            System.out.println("Пользователь обновлён!");
            loadAndDisplayUsers();
        } catch (SQLException e) {
            throw new DatabaseException(CANNOT_UPDATE_USER);
        }
    }

    public void deleteUser() {
        try {
            int id = -1;
            while (id == -1) {
                System.out.print("Введите ID пользователя для удаления: ");
                try {
                    id = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введите число (например, 1)!");
                    id = -1;
                }
            }

            User userToDelete = model.getUserById(id);
            if (userToDelete == null) {
                System.out.println("Пользователь с ID " + id + " не найден.");
                return;
            }

            System.out.print(
                    "Вы уверены, что хотите удалить пользователя '" + userToDelete.getName() + "' (ID: "
                            + id + ")? (да/нет): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();
            if ("да".equals(confirmation)) {
                model.deleteUser(id);
                System.out.println("Пользователь удалён!");
            } else {
                System.out.println("Удаление отменено.");
            }
            loadAndDisplayUsers();
        } catch (SQLException e) {
            throw new DatabaseException(CANNOT_DELETE_USER);
        }
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Показать пользователей");
            System.out.println("2. Добавить пользователя");
            System.out.println("3. Обновить пользователя");
            System.out.println("4. Удалить пользователя");
            System.out.println("5. Выход");
            System.out.println("\n");
            System.out.print("Выберите действие: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> loadAndDisplayUsers();
                case 2 -> addUser();
                case 3 -> updateUser();
                case 4 -> deleteUser();
                case 5 -> {
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}