package ru.shadrag.hw3.services;

import org.springframework.stereotype.Service;
import ru.shadrag.hw3.models.User;

/**
 * Класс для создания пользователя
 */
@Service
public class UserService {
    public User createUser(String name, int age, String email){
        return new User(name, age, email);
    }

}
