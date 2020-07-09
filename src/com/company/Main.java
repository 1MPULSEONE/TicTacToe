package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        char[] symbols = input.toCharArray();
        int counter = 0;
        int counterX = 0;
        int counterO = 0;
        boolean xWins = false;
        boolean oWins = false;
        boolean loop = true;
        boolean loopTwo = true;
        char[][] output = new char[3][3];
        System.out.println("---------");
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                output[i][j] = symbols[counter];
                counter++;
                System.out.print(output[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        while (loop) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += output[i][j];
                    if (output[i][j] == 'X') {
                        counterX++;
                    }
                    if (output[i][j] == 'O') {
                        counterO++;
                    }
                    // left-right diagonal
                    if (output[0][0] + output[1][1] + output[2][2] == 264) {
                        System.out.println("X wins");
                        loop = false;
                        loopTwo = false;
                        i = 2;
                        j = 2;
                    } else if (output[0][0] + output[1][1] + output[2][2] == 237) {
                        System.out.println("O wins");
                        loop = false;
                        loopTwo = false;
                        i = 2;
                        j = 2;
                    }
                    // right-left diagonal
                    if (output[0][2] + output[1][1] + output[2][0] == 264) {
                        System.out.println("X wins");
                        loop = false;
                        loopTwo = false;
                        i = 2;
                        j = 2;
                    } else if (output[0][2] + output[1][1] + output[2][0] == 237) {
                        System.out.println("O wins");
                        loop = false;
                        loopTwo = false;
                        i = 2;
                        j = 2;
                    }
                    // up-down
                    if (output[0][j] + output[1][j] + output[2][j] == 264) {
                        xWins = true;
                    }
                    if (output[0][j] + output[1][j] + output[2][j] == 237) {
                        oWins = true;
                    }
                }
                // row
                if (sum == 264) {
                    System.out.println("X wins");
                    loop = false;
                    loopTwo = false;
                    break;
                } else if (sum == 237) {
                    System.out.println("O wins");
                    loop = false;
                    loopTwo = false;
                    break;
                }
                sum = 0;
                if (i == 2) {
                    loop = false;
                }
            }
        }
        while (loopTwo) {
            //impossible part
            if (Math.abs(counterX - counterO) > 1 || (xWins && oWins)) {
                System.out.println("Impossible");
                break;
            }
            // checked x and o
            if (xWins) {
                System.out.println("X wins");
                break;
            }
            if (oWins) {
                System.out.println("O wins");
                break;
            }
            //check draw
            if (counterX + counterO == 9) {
                System.out.println("Draw");
                break;
            }
            //check game not finished
            if (counterX == 3 && counterO == 3) {
                System.out.println("Game not finished");
                break;
            }
        }
    }
}