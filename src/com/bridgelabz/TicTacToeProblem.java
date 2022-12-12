package com.bridgelabz;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeProblem {
    static String[] board = new String[9];
    static String turn;

    static void printBoard(){

        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");

        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");

        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
    }
    static String checkWinner(){
        for (int a=0; a<8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];  // sum of value across winning line
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            if (line.equals("XXX")) {
                return "X";
            }
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }
        if(turn == "X"){
            System.out.println(
                     "Your turn; enter a slot number to place " + turn + " in:");
        }
        return null;
    }
    static void initgame() {
        for (int a=0; a<9; a++) {
            board[a] = String.valueOf(a + 1);
        }
    }
    static void startGame() {
        Scanner in = new Scanner(System.in);
        String winner = null;
        System.out.println("Choose Head or Tail. Enter 1 for Head and 0 for Tail");
        int choice = in.nextInt();

        int randomCheck = (int) Math.floor(Math.random()*10) % 2;

        if ( choice == randomCheck ) {
            System.out.println("You won the toss! You can start the game by entering X in any column");
            turn="X";
        } else {
            System.out.println("Computer won the toss! Computer will start the game by entering O in any column");
            turn="O";
        }
        initgame();
        int numInput = 0;
        while (winner == null) {
            if(turn == "X"){            // if player, turn read from commandline
                // Next thing I do is check
                //if my Opponent can
                //win then play to block
                //it
                //If neither of us are
                // winning then My first
                //choice would be to
                //take one of the available corners
                numInput = in.nextInt();
            } else {
                numInput = (int) Math.floor(Math.random()*10) % 9 + 1;  // if computer, generate random value
            }
            if (board[numInput - 1].equals(    // to match with array index (numInput - 1)
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    System.out.println("Computer has entered O in " + numInput + "position");
                    turn = "X";
                }
                printBoard();
                winner = checkWinner();
            }
            else {
                if(turn == "X") {
                    System.out.println("Slot already taken; re-enter slot number:");
                }
            }
        }
        if (winner.equalsIgnoreCase("draw")) {              // compare value of winner and draw
            System.out.println("It's a draw! Thanks for playing.");
        }
        else {
            if ( winner == "X"){
                System.out.println("Congratulations! You have won! Thanks for playing.");
            } else {
                System.out.println("Sorry! Computer has won! Thanks for playing.");
            }
        }
    }
    public static void main(String[] args) {
        startGame();
    }
}