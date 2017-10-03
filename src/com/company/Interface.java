package com.company;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {
    private Scanner scanner = new Scanner(System.in);

    public void welcome() {

        int selection;
        do {
            selection = 4;
            scanner = new Scanner(System.in);
            createPlayerArray();
            System.out.println("\nWelcome to Rock, Paper, Scissors!");
            System.out.println("What do you wish to do?");
            System.out.println("1 : Add Player");
            System.out.println("2 : Play Game");
            System.out.println("3 : Show Stats");

            try {
                do {
                    selection = scanner.nextInt();
                } while (selection > 4 || selection < 0);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number between 0 & 3");
            }
            menuSelection(selection);
        } while (selection!=0);
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
            case 0:
                break;
            default:
                System.out.println("Input error, try again!");
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
    }

    public static void playGame(){

        Scanner scanner = new Scanner(System.in);
        Player playerOneHolder;
        Player playerTwoHolder;
        do {
        System.out.println("Please enter the name of player 1");
        String playerOneName = scanner.nextLine();
        System.out.println("Please enter the name of player 2");
        String playerTwoName = scanner.nextLine();
            playerOneHolder = getPlayerByName(playerOneName);
            playerTwoHolder = getPlayerByName(playerTwoName);
            if (playerOneHolder == null || playerTwoHolder == null ){
                System.out.println("One or more usernames can not be found!");
                return;
            }
        } while(playerOneHolder == null || playerTwoHolder == null);
        boolean flagEndGame = false;
        do {
            scanner = new Scanner(System.in);
            new Game(playerOneHolder, playerTwoHolder);
            System.out.println("Rematch? (Press Y)");
            if (scanner.nextLine().toLowerCase().equals("Y")){
                flagEndGame = true;
            }
        } while (!flagEndGame);
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

        String leftAlignFormat = "| %-15s | %-4d | %-4d |%n";

        System.out.format("+-----------------+------+------+%n");
        System.out.format("| USERNAME        | WINS | LOSS |%n");
        System.out.format("+-----------------+-------------+%n");
        for (int i = 0; i < players.size(); i++) {
            System.out.format(leftAlignFormat, players.get(i).getName(), players.get(i).getCurrentWins(), players.get(i).getCurrentLosses());
        }
        System.out.format("+-----------------+-------------+%n");

    }
}
