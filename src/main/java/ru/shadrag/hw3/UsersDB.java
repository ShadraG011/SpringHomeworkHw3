package ru.shadrag.hw3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.shadrag.hw3.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class UsersDB {
    private final List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }
}
