package org.freshwerehouse;

import org.freshwerehouse.persistance.dao.UserDAO;
import org.freshwerehouse.persistance.dao.impl.UserDAOImpl;
import org.freshwerehouse.service.UserPresenterService;
import org.freshwerehouse.view.UserView;

public class Main {

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        UserDAO model = new UserDAOImpl();
        UserView view = new UserView();
        UserPresenterService presenter = new UserPresenterService(model, view);

        presenter.start();
    }
}