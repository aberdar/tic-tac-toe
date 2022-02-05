package personal;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static int playerOneScore = 0;
    static int playerTwoScore = 0;
    static int switcher;

    public static void main(String[] args) {
         /*

         Helpful indices
         [0][0] , [0][2] , [0][4]
         [1][0] , [1][2] , [1][4]
         [2][0] , [2][2] , [2][4]

         */

        char[][] gameBoard = {
                {'_','|','_','|','_'},
                {'_','|','_','|','_'},
                {' ','|',' ','|',' '}
        };

        printBoard(gameBoard);

        boolean gameOver = false;
        boolean playAgain = true;

        while (playAgain) {
            while (!gameOver) {
                playerInput(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }
            }

            System.out.println("Player one score: " + playerOneScore);
            System.out.println("Player two score: " + playerTwoScore);
            System.out.println();

            System.out.println("Would you like to play again? yes/no");
            scan.nextLine();
            String answer = scan.nextLine();

            switch (answer) {
                case "yes":
                    playAgain = true;
                    System.out.println("Dope! Let's play again");
                    resetBoard(gameBoard);
                    gameOver = false;
                    printBoard(gameBoard);
                    break;

                case "no":
                    playAgain = false;
                    System.out.println("Thanks for playing");
                    break;

                default:
                    break;
            }
        }

    }

    static public void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char element: row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    static public void playerInput(char[][] gameBoard) {
        int player = switcher;

        System.out.println("Player " + (player+1));
        System.out.print("Choose a position from 1 to 9: ");
        int move = scan.nextInt();

        boolean result = isValidMove(move, gameBoard);
        while (!result) {
            System.out.println("Sorry! Invalid Move. Try again");
            move = scan.nextInt();
            result = isValidMove(move,gameBoard);
        }

        updateBoard(move, player, gameBoard);

        switcher++;
        if (switcher == 2) {
            switcher = 0;
        }
    }

    public static void updateBoard(int position, int player, char[][] gameBoard) {
        char character;

        if (player == 0) {
            character = 'X';
        } else {
            character = 'O';
        }

        /*
            [0][0] , [0][2] , [0][4],
            [1][0] , [1][2] , [1][4],
            [2][0] , [2][2] , [2][4]
         */

        switch (position) {
            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;

            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;

            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;

            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;

            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;

            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;

            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;

            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;

            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;

            default:
                break;
        }
    }

    static public boolean isValidMove(int move, char[][] gameBoard) {
        switch (move){
            case 1:
                return gameBoard[0][0] == '_';

            case 2:
                return gameBoard[0][2] == '_';

            case 3:
                return gameBoard[0][4] == '_';

            case 4:
                return gameBoard[1][0] == '_';

            case 5:
                return gameBoard[1][2] == '_';

            case 6:
                return gameBoard[1][4] == '_';

            case 7:
                return gameBoard[2][0] == ' ';

            case 8:
                return gameBoard[2][2] == ' ';

            case 9:
                return gameBoard[2][4] == ' ';

            default:
                return false;
        }
    }

    public static boolean isGameOver(char[][] gameBoard) {
        if(gameBoard[0][0] == 'X'&& gameBoard[0][2] == 'X' && gameBoard [0][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameBoard[0][0] == 'O'&& gameBoard[0][2] == 'O' && gameBoard [0][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }
        if(gameBoard[1][0] == 'X'&& gameBoard[1][2] == 'X' && gameBoard [1][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameBoard[1][0] == 'O'&& gameBoard[1][2] == 'O' && gameBoard [1][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }
        if(gameBoard[2][0] == 'X'&& gameBoard[2][2] == 'X' && gameBoard [2][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameBoard[2][0] == 'O'&& gameBoard[2][2] == 'O' && gameBoard [2][4] == 'O' ) {
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        //Vertical Wins

        if(gameBoard[0][0] == 'X'&& gameBoard[1][0] == 'X' && gameBoard [2][0] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameBoard[0][0] == 'O'&& gameBoard[1][0] == 'O' && gameBoard [2][0] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameBoard[0][2] == 'X'&& gameBoard[1][2] == 'X' && gameBoard [2][2] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameBoard[0][2] == 'O'&& gameBoard[1][2] == 'O' && gameBoard [2][2] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameBoard[0][4] == 'X'&& gameBoard[1][4] == 'X' && gameBoard [2][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameBoard[0][4] == 'O'&& gameBoard[1][4] == 'O' && gameBoard [2][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        //Diagonal Wins
        if(gameBoard[0][0] == 'X'&& gameBoard[1][2] == 'X' && gameBoard [2][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameBoard[0][0] == 'O'&& gameBoard[1][2] == 'O' && gameBoard [2][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameBoard[2][0] == 'X'&& gameBoard[1][2] == 'X' && gameBoard [0][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameBoard[2][0] == 'O'&& gameBoard[1][2] == 'O' && gameBoard [0][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' && gameBoard[1][0] !='_'&&
                gameBoard[1][2] != '_' && gameBoard[1][4] != '_' && gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' '){
            System.out.println("It's a tie");
            return true;
        }

        return false;
    }

    public static void resetBoard(char[][] gameBoard){
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';
    }
}
