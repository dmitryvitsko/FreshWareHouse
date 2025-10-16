package org.freshwerehouse.view;

import java.util.List;
import org.freshwerehouse.persistance.entity.User;

public class UserView {

    public void displayUsers(List<User> users) {

        System.out.println("+-----+----------------------+----------------------+------------------+--------------------------+");
        System.out.println("| ID  | Name                 | Email                | Password         | Position                 |");
        System.out.println("+-----+----------------------+-----------------------------------------+--------------------------+");

        for (User user : users) {
            String id = String.format("%-3d", user.getId());
            String name = String.format("%-20s", user.getName().substring(0, Math.min(user.getName().length(), 20)));
            String email = String.format("%-20s", user.getEmail().substring(0, Math.min(user.getEmail().length(), 20)));
            String pass = String.format("%-16s", user.getPassword().substring(0, Math.min(user.getPassword().length(), 13)));
            String position = String.format("%-24s", user.getPosition().substring(0, Math.min(user.getPosition().length(), 30)));
            System.out.printf("| %s | %s | %s | %s | %s |  \n", id, name, email, pass, position);
        }

        System.out.println("+-----+----------------------+----------------------+------------------+--------------------------+");
    }

}