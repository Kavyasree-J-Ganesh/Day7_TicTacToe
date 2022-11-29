package com.bridgelabz;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeProblem {
    static String[] board = new String[9];
    static String turn;

    static void printBoard(){
        for(int i=0;i<board.length;i++) {
            System.out.println(board[i]);
        }
    }

    static String checkWinner(){
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
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
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
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
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");

        return null;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String winner = null;
        turn = "X";
        System.out.println(
                "X will play first. Enter a slot number to place X in:");
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        while (winner == null) {
            int numInput = in.nextInt();

            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }

        }
    }
}
