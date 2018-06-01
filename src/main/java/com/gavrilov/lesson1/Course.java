package com.gavrilov.lesson1;

public class Course {


    // Проходим полосу препятствий
    public void doIt(Team team) {
        for (int i = 0; i <team.getPlayers().length ; i+=2) {
            team.getPlayers()[i].setCourseDone(true);
        }
    }
}

