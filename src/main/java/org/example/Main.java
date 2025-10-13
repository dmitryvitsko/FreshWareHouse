package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        UserDAO model = new UserDAOImpl();
        UserView view = new UserView();
        UserPresenter presenter = new UserPresenter(model, view);

        presenter.start();
    }
}