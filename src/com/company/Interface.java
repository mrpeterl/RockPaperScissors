package com.company;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {
    private Scanner scanner = new Scanner(System.in);

    public void welcome() {

        createPlayerArray();
        System.out.println("\nWelcome to Rock, Paper, Scissors!");
        System.out.println("What do you wish to do?");
        System.out.println("1 : Add Player");
        System.out.println("2 : Play Game");
        System.out.println("3 : Show Stats");

        int selection = 0;
        try {
            do {
                selection = scanner.nextInt();
            } while (selection > 3 || selection < 1);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number between 1 & 3");
        }
        menuSelection(selection);
    }

    public void menuSelection(int selection) {
        switch (selection) {
            case 1:
                createPlayer();
                break;
            case 2:
                playGame();
                break;
            case 3:
                showStats();
                break;
        }

    }

    static ArrayList<Player> players = new ArrayList<Player>();

    public void createPlayerArray() {
        if (players == null) {
            players = new ArrayList<Player>();
        }
    }

    public void createPlayer() {
        scanner = new Scanner(System.in);
        boolean duplicates = false;
        String name = null;
        do {
            System.out.println("Please enter a name : ");
            name = scanner.nextLine();
            duplicates = false;
            for (int i = 0; i < players.size(); i++) {
                if (name.equals(players.get(i).getName())) {
                    duplicates = true;
                }
            }
        }while(duplicates==true);
        players.add(new Player(name));
        welcome();
    }

    public static void playGame(){
        //Game newGame = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of player 1");
        String playerOneName = scanner.nextLine();
        System.out.println("Please enter the name of player 2");
        String playerTwoName = scanner.nextLine();
        Player playerOneHolder;
        Player playerTwoHolder;
        do {
            playerOneHolder = getPlayerByName(playerOneName);
            playerTwoHolder = getPlayerByName(playerTwoName);
        }while(playerOneHolder == null || playerOneHolder == null);

    }

    public static Player getPlayerByName(String username){
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getName().equals(username)){
                return players.get(i);
            }
        }
        return null;
    }


    public void showStats(){

            for(int i = 0; i < players.size();i++){
                System.out.println(players.get(i).toString());
            }
        welcome();
    }
}
