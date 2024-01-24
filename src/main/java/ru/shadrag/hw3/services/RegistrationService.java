package ru.shadrag.hw3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shadrag.hw3.models.User;

/**
 * Класс для осуществления регистрации
 */
@Service
public class RegistrationService {
    private final UserService userService;

    @Autowired
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public User registerUser(String name, int age, String email) {
        return userService.createUser(name, age, email);
    }
}
