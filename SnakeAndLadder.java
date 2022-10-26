import java.util.Random;

public class SnakeAndLadder {
    // Fixed Variables
    static final int INITIAL_POSITION = 0;
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int WIN_POSITION = 3;
    //Constants
    static int playerPosition = INITIAL_POSITION;
    static int turn = 0;
    static int rollDiceCounter = 0;
    static int firstPlayerPosition = INITIAL_POSITION;
    static int secondPlayerPosition = INITIAL_POSITION;

    private static int rollDice() {
        Random random = new Random();
        return  random.nextInt(6) + 1;
    }
    private static void repeatTillPlayerReachesGoal() {
        Random random = new Random();
        int option = random.nextInt(3);
        int randomDiceMove = rollDice();
        rollDiceCounter++;

        if (option == NO_PLAY) {
            playerPosition = playerPosition;
            System.out.println("Player is a fault so no changes to current position" + playerPosition);
        }
        else if (option == LADDER) {
            playerPosition += randomDiceMove;
            System.out.println(randomDiceMove + "positions" + playerPosition);
        }
        else if (option == SNAKE) {
            if (playerPosition > randomDiceMove) {
                playerPosition -= randomDiceMove;
            } else {
                playerPosition = 0;
            }
            System.out.println("You have stepped on snake so you will go back to" +randomDiceMove + " step back " + playerPosition);
        }
        System.out.println("Total number of dice rolled is :" +rollDiceCounter);
    }
    private static void playGame() {
        while (playerPosition != WIN_POSITION) {
            if (turn == 0) {
                playerPosition = firstPlayerPosition;
                repeatTillPlayerReachesGoal();
                secondPlayerPosition = playerPosition;
                turn = 0;
            }
        }
        checkWinner();
    }

    private static void checkWinner() {
        if (firstPlayerPosition == WIN_POSITION) {
            System.out.println("Player one Won");
        } else {
            System.out.println("Player two Won");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome snake and ladder game");
        playGame();
    }
}
