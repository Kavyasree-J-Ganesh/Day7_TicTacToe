package com.bridgelabz;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeProblem {


        static String[] board = new String[9];
        static String turn;

        static void printBoard() {
            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i]);
            }
        }

        static String checkWinner() {

            for (int a = 0; a < 9; a++) {
                if (Arrays.asList(board).contains(
                        String.valueOf(a + 1))) {
                    break;
                } else if (a == 8) {
                    return "draw";
                }
            }


            return null;
        }


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String winner = null;
            turn = "X";
            while (winner == null) {
                int numInput = in.nextInt();
                for (int a = 0; a < 9; a++) {
                    board[a] = String.valueOf(a + 1);
                }
                if (board[numInput - 1].equals(
                        String.valueOf(numInput))) {
                    board[numInput - 1] = turn;

                    if (turn.equals("X")) {
                        turn = "O";
                    } else {
                        turn = "X";
                    }

                    printBoard();
                    winner = checkWinner();
                } else {
                    System.out.println(
                            "Slot already taken; re-enter slot number:");
                }
            }
        }
}