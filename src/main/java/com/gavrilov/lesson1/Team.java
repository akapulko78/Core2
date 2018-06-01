package com.gavrilov.lesson1;


public class Team {
    private final String name = "Team";

    private final Player[] players;

    public Team() {
        players = new Player[]{
                new Player("player1"),
                new Player("player2"),
                new Player("player3"),
                new Player("player4")};
    }

    public Player[] getPlayers() {
        return players;
    }

    public void TeamInfo() {
        for (Player player : players) {
            System.out.println(player.getName());
        }

    }

    public void showResults() {
        for (Player player : players) {
            if (player.isCourseDone()) {
                System.out.println(player.getName());
            }
        }
    }

}
