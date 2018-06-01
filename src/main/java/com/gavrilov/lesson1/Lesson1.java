package com.gavrilov.lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        Course c = new Course();// Создаем полосу препятствий
        Team team = new Team(); // Создаем команду
        team.TeamInfo(); //выводим информацию о команде
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты

    }
}


