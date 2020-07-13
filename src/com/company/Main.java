package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char userChar;
        int counterChar = 0;
        int coordinateX = 0;
        int coordinateY = 0;
        int counterX = 0;
        int counterO = 0;
        int x = 0;
        int y = 0;
        boolean xWins = false;
        boolean oWins = false;
        boolean loop = true;
        boolean loopTwo = false;
        char[][] output = new char[3][3];
        int sum = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                output[i][j] = ' ';
                System.out.print(output[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        while (loop) {
            //Choosing current char.
            if (counterChar % 2 == 0) {
                userChar = 'X';
            } else {
                userChar = 'O';
            }
            //Checking coordinates
            System.out.print("Enter the coordinates: ");
            try {
                String coordinatesString = scanner.nextLine();
                String[] pieces = coordinatesString.split(" ");
                x = Integer.parseInt(pieces[0]);
                y = Integer.parseInt(pieces[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (x > 3 || y > 3 || x < 0 || y < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else {
                coordinateX = 3 - y;
                coordinateY = x - 1;
            }
            if (output[3 - y][x - 1] == 'O' || output[3 - y][x - 1] == 'X' ) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    sum += output[i][j];
                    if (output[i][j] == 'X') {
                        counterX++;
                    }
                    if (output[i][j] == 'O') {
                        counterO++;
                    }
                    output[coordinateX][coordinateY] = userChar;
                    // left-right diagonal
                    if (output[0][0] + output[1][1] + output[2][2] == 264) {
                        xWins = true;
                        loopTwo = true;
                    } else if (output[0][0] + output[1][1] + output[2][2] == 237) {
                        oWins = true;
                        loopTwo = true;
                    }
                    // right-left diagonal
                    if (output[0][2] + output[1][1] + output[2][0] == 264) {
                        xWins = true;
                        loopTwo = true;
                    } else if (output[0][2] + output[1][1] + output[2][0] == 237) {
                        oWins = true;
                        loopTwo = true;
                    }
                    // up-down
                    if (output[0][j] + output[1][j] + output[2][j] == 264) {
                        xWins = true;
                        loopTwo = true;
                    }
                    if (output[0][j] + output[1][j] + output[2][j] == 237) {
                        oWins = true;
                        loopTwo = true;
                    }
                    System.out.print(output[i][j] + " ");
                }
                if (counterO + counterX == 9) {
                    loopTwo = true;
                }
                // row
                if (sum == 264) {
                    xWins = true;
                    loopTwo = true;
                } else if (sum == 237) {
                    oWins = true;
                    loopTwo = true;
                }
                System.out.println("|");
                sum = 0;
            }
            System.out.println("---------");
            while (loopTwo) {
                //impossible part
                if (Math.abs(counterX - counterO) > 1 || (xWins && oWins)) {
                    System.out.println("Impossible");
                    System.out.println(counterX+ "x");
                    System.out.println(coordinateY + "y");
                    loop = false;
                    break;
                }
                // checked x and o
                if (xWins) {
                    System.out.println("X wins");
                    loop = false;
                    break;
                }
                if (oWins) {
                    System.out.println("O wins");
                    loop = false;
                    break;
                }
                //check draw
                if (counterX + counterO == 9) {
                    System.out.println("Draw");
                    loop = false;
                    break;
                }
                //check game not finished
                if (counterX == 3 && counterO == 3) {
                    System.out.println("Game not finished");
                    loop = false;
                    break;
                }
            }
            counterChar++;
            counterO = 0;
            counterX = 0;
        }
    }
}
