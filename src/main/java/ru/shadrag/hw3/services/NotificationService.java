package ru.shadrag.hw3.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.shadrag.hw3.models.User;

@Service
@Scope("singleton")
public class NotificationService {

    public String registeredUser(User user) {
        return String.format("Пользователь %s %d %s зарегистрирован\n", user.getName(), user.getAge(), user.getEmail());
    }

    public String createdUser(User user) {
        return String.format("Пользователь %s %d %s создан\n", user.getName(), user.getAge(), user.getEmail());
    }

    public String addedUser(User user) {
        return String.format("Пользователь %s %d %s добавлен в базу данных\n", user.getName(), user.getAge(), user.getEmail());
    }

    public String filteredUsersByAge(int age) {
        return String.format("Выведен список пользователей старше %d\n", age);
    }

    public String getAvgAge() {
        return "Показан средний возраст пользователей\n";
    }

    public String sortedUsersByAgeASC() {
        return "Пользователи отсортированы по возрасту в возрастающем порядке\n";
    }

    public String sortedUsersByAgeDESC() {
        return "Пользователи отсортированы по возрасту в убывающем порядке\n";
    }

    public String getUsers() {
        return "Выведен весь список пользователей\n";
    }
}
