package com.company;

public class Game {
    Player playerOne;
    Player playerTwo;

    MoveType playerOneMove = null;
    MoveType playerTwoMove = null;

    static int roundComparisonLogic(MoveType playerOneMove, MoveType playerTwoMove) {
        switch (playerOneMove){
            case rock:
                switch (playerTwoMove){
                    case rock:
                        return 0;
                    case paper:
                        return 2;
                    case scissors:
                        return 1;
                }
            case paper:
                switch (playerTwoMove){
                    case rock:
                        return 1;
                    case paper:
                        return 0;
                    case scissors:
                        return 2;
                }
            case scissors:
                switch (playerTwoMove){
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
}