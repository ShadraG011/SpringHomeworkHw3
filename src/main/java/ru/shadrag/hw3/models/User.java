package ru.shadrag.hw3.models;

/**
 * Класс сущности пользователя
 */
public class User {

    //region КОНСТРУКТОРЫ

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //endregion

    //region ГЕТТЕРЫ и СЕТТЕРЫ

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", email='" + email + '\'' +
               '}';
    }

    //endregion

    //region ПОЛЯ
    private String name;
    private int age;
    private String email;
    //endregion


}
