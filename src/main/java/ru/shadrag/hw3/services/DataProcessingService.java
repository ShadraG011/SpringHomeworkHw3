package ru.shadrag.hw3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shadrag.hw3.models.User;
import ru.shadrag.hw3.UsersDB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс для работы с данными
 */
@Service
public class DataProcessingService {
    private StringBuilder result;

    private final UsersDB usersDB;
    private final NotificationService notificationService;
    private final RegistrationService registrationService;

    @Autowired
    public DataProcessingService(UsersDB usersDB, NotificationService notificationService, RegistrationService registrationService) {
        this.usersDB = usersDB;
        this.notificationService = notificationService;
        this.registrationService = registrationService;
    }

    public String filterUsersByAge(int age) {
        List<User> copyUserList = new ArrayList<>(usersDB.getUsers());

        result =  new StringBuilder();
        copyUserList.stream().filter(user -> user.getAge() > age).forEach(user -> result.append(user).append("\n"));

        return notificationService.filteredUsersByAge(age) + result;
    }

    public String getAverageAge() {
        double averageAge = usersDB.getUsers().stream().mapToInt(User::getAge).average().orElse(0);
        return notificationService.getAvgAge() + String.format("%.2f", averageAge);
    }

    public String sortUserByAgeASC() {
        List<User> copyUserList = new ArrayList<>(usersDB.getUsers());
        copyUserList.sort(Comparator.comparingInt(User::getAge));

        result =  new StringBuilder();
        copyUserList.forEach(user -> result.append(user).append("\n"));

        return notificationService.sortedUsersByAgeASC() + result;
    }

    public String sortUserByAgeDESC() {
        List<User> copyUserList = new ArrayList<>(usersDB.getUsers());
        copyUserList.sort((o1, o2) -> o2.getAge() - o1.getAge());

        result =  new StringBuilder();
        copyUserList.forEach(user -> result.append(user).append("\n"));

        return notificationService.sortedUsersByAgeDESC() + result;
    }

    public String getUsers() {
        result =  new StringBuilder();
        usersDB.getUsers().forEach(user -> result.append(user).append("\n"));

        return notificationService.getUsers() + result;
    }

    public String registration(String name, int age, String email) {
        User registredUser = registrationService.registerUser(name, age, email);
        usersDB.getUsers().add(registredUser);
        return notificationService.createdUser(registredUser) +
               notificationService.registeredUser(registredUser) +
               notificationService.addedUser(registredUser);
    }

}
