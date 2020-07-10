package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        input = input.replace('_',' ');
        char[] symbols = input.toCharArray();
        int counter = 0;
        int cordinateX = 0;
        int cordinateY = 0;
        int counterX = 0;
        int counterO = 0;
        int x = 0;
        int y = 0;
        boolean xWins = false;
        boolean oWins = false;
        boolean loop = true;
        boolean loopTwo = true;
        boolean impossible = false;
        char[][] output = new char[3][3];
        int sum = 0;
        System.out.println("---------");
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
        counter = 0;
        while (loop) {
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
                cordinateX = 3 - y;
                cordinateY = x - 1;
            }
            if (output[3 - y][x - 1] == 'O' || output[3 - y][x - 1] == 'X' ) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    if ((output[cordinateX][cordinateY] == ' ' || output[cordinateX][cordinateY] == '_') && counter == 0 ) {
                        output[cordinateX][cordinateY] = 'X';
                        counter++;
                    }
                    System.out.print(output[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");
            loop = false;
        }
           /* for (int i = 0; i < 3; i++) {
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
            */
    }
}
