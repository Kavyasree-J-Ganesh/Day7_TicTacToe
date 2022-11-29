package com.bridgelabz;

public class TicTacToeProblem {
    static char[] board = new char[0];

    char input() {
        int randomChar = (int) Math.floor(Math.random() * 10 % 2);
        if (randomChar == 1) {
            return 'x';
        } else {
            return '0';
        }
    }

    public static void main(String[] args) {

    }
}
