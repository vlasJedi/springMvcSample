package org.mvcsample.dao;

import org.mvcsample.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    private final List<User> users;
    // object init block
    {
        users = new ArrayList<>(){};
        users.add(new User(0, "Vlas"));
        users.add(new User(1, "Dmytro"));
        users.add(new User(2, "Petro"));
    }

    public List<User> getAll() {
        return users;
    }

    public User get(int id) {
        return users.stream().filter((user) -> user.getId() == id)
                .findFirst().orElse(null);
    }


}
