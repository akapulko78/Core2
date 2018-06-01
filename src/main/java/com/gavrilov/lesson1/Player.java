package com.gavrilov.lesson1;

public class Player {
    private final String name;
    private boolean courseDone;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isCourseDone() {
        return courseDone;
    }

    public void setCourseDone(boolean courseDone) {
        this.courseDone = courseDone;
    }

}
