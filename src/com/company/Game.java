package com.company;

import java.util.Scanner;

public class Game {
    Player playerOne;
    Player playerTwo;
    MoveType playerOneMove = null;
    MoveType playerTwoMove = null;
    Scanner scanner;

    Game(Player playerOne, Player playerTwo){
        setPlayerOne(playerOne);
        setPlayerTwo(playerTwo);
        playGame();
    }

    public Player getPlayerOne() {
        return playerOne;
    }
    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }
    public Player getPlayerTwo() {
        return playerTwo;
    }
    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }
    public MoveType getPlayerOneMove() {
        return playerOneMove;
    }
    public void setPlayerOneMove(MoveType playerOneMove) {
        this.playerOneMove = playerOneMove;
    }
    public MoveType getPlayerTwoMove() {
        return playerTwoMove;
    }
    public void setPlayerTwoMove(MoveType playerTwoMove) {
        this.playerTwoMove = playerTwoMove;
    }

    void playGame(){
        do {
            setPlayerOneMove(requestPlayerMove(playerOne));
            setPlayerTwoMove(requestPlayerMove(playerTwo));
        } while (roundComparisonLogic() == 0);
    }

    int roundComparisonLogic() {
        switch (playerOneMove) {
            case rock:
                switch (playerTwoMove) {
                    case rock:
                        System.out
                        return 0;
                    case paper:
                        return 2;
                    case scissors:
                        return 1;
                }
            case paper:
                switch (playerTwoMove) {
                    case rock:
                        return 1;
                    case paper:
                        return 0;
                    case scissors:
                        return 2;
                }
            case scissors:
                switch (playerTwoMove) {
                    case rock:
                        return 2;
                    case paper:
                        return 1;
                    case scissors:
                        return 0;
                }
        }
        throw new IndexOutOfBoundsException();
    }

    MoveType requestPlayerMove(Player currentPlayer){
        String stringPlayerMove;
        System.out.flush();
        do {
            System.out.println(">" + Player.name + ", make your move!");
            scanner = new Scanner(System.in);
            stringPlayerMove = scanner.nextLine().toLowerCase();
        } while (stringPlayerMove != "rock" || stringPlayerMove != "paper" || stringPlayerMove != "scissors");
        switch (stringPlayerMove){
            case "rock":
                return MoveType.rock;
            case "paper":
                return MoveType.paper;
            case "scissors":
                return MoveType.scissors;
            default:
                throw new IndexOutOfBoundsException();
        }
    }
}