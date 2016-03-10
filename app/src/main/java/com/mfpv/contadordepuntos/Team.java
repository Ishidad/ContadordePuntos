package com.mfpv.contadordepuntos;

public class Team {

    int points = 0;
    int imageView = 0;
    String teamName = "";

    public Team() {
    }

    public void addName(String name) {
        teamName = name;
    }

    public String getName() {
        return teamName;
    }

    public void increasePoints() {
        if (points < 30) {
            points++;
        }
    }

    public void decreasePoints() {
        if (points > 0) {
            points--;
        }
    }

    public int getPoints() {
        return points;
    }

    public int getImageView() {
        if (points >= 0 && points <= 5) {
            return 0;
        }
        else if (points > 5 && points <= 10) {
            return 1;
        }
        else if (points > 10 && points <= 15) {
            return 2;
        }
        else if (points > 15 && points <= 20) {
            return 3;
        }
        else if (points > 20 && points <= 25) {
            return 4;
        }
        else if (points > 25 && points <= 30) {
            return 5;
        }
        return 0;
    }

    public int calculatePoints() {
        if (points > 5 && points <= 10) {
            return points - 5;
        }
        else if (points > 10 && points <= 15) {
            return points - 10;
        }
        else if (points > 15 && points <= 20) {
            return points - 15;
        }
        else if (points > 20 && points <= 25) {
            return points - 20;
        }
        else if (points > 25 && points <= 30) {
            return points - 25;
        }
        return points;
    }

    public void resetPoints() {
        points = 0;
    }

    public void resetView() {
        imageView = 0;
    }
}
