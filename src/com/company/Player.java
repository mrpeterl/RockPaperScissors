package com.company;
import java.util.Scanner;

import java.util.Scanner;

public class Player {

    private int currentLosses;
    private int currentWins;
    private String name;

    public Player(String name){
        this.name = name;
        this.currentWins = 0;
        this.currentLosses = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentLosses() {
        return currentLosses;
    }

    public void setCurrentLosses(int currentLosses) {
        this.currentLosses = currentLosses;
    }

    public int getCurrentWins() {
        return currentWins;
    }

    public void setCurrentWins(int currentWins) {
        this.currentWins = currentWins;
    }

    @Override
    public String toString() {
        return "\nPlayer" +
                "\nName : " + name +
                "\nCurrent Wins : " + currentWins  +
                "\nCurrent Losses : " + currentLosses
                ;
    }
}