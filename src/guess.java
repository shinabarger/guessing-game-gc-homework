import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by davidshinabarger on 1/30/17.
 */
public class guess {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
        int differenceAbove = 0;
        int differenceBelow = 0;
        int difference = 0;
        int attemptsMade = 1;
        char answerChar = 'Y';
        int highScore = 1000;

        while (answerChar == 'Y') {
            int userNumber = Validator.getInt(scan, "Guess a number 1-100 to try and guess the computer's number.", 1, 100);


            differenceAbove = userNumber - randomNumber;
            differenceBelow = randomNumber - userNumber;
            if (differenceAbove > differenceBelow) {
                difference = differenceAbove;
            } else difference = differenceBelow;

            while (userNumber != randomNumber) {
                if (userNumber > 100 || userNumber <= 0) {
                    System.out.println("Oops! That wasn't a # between 1 & 100!");
                }

                if (userNumber > randomNumber && difference < 10) {
                    System.out.println("Too high!");
                } else if (difference >= 10 && userNumber > randomNumber) {
                    System.out.println("Way too high!");
                }
                if (userNumber < randomNumber && (difference < 10)) {
                    System.out.println("Too low!");
                } else if ((difference >= 10) && userNumber < randomNumber) {
                    System.out.println("WAY too low!");
                }

                userNumber = Validator.getInt(scan, "Please enter another number: ", 0, 100);

                differenceAbove = userNumber - randomNumber;
                differenceBelow = randomNumber - userNumber;
                if (differenceAbove > differenceBelow) {
                    difference = differenceAbove;
                } else difference = differenceBelow;

                System.out.println("You guessed: " + userNumber);
                ++attemptsMade;
            }

            //when the user guessed correctly
            System.out.println("Congrats! The number was " + userNumber + "! It took you " + (attemptsMade) + " times to guess correctly!");
            randomNumber = ThreadLocalRandom.current().nextInt(1, 101);

            highScore = checkHighScore(attemptsMade, highScore);

            //ask user if they want to play again +
            System.out.println("Want to play again? Y/N ");
            String answer = scan.nextLine();
            answerChar = answer.charAt(0);
            attemptsMade = 0;
            if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                System.out.println("That's not Y or N! Let's try that again");
                System.out.println("Want to play again? Y/N ");
                scan.nextLine();
            }
            if (answer.equals("N")) {
                break;
            } else continue;

        }
        System.out.println("Thanks for playing.");
    }
    private static int checkHighScore(int attemptsMade, int highScore) {
        if (highScore > attemptsMade) {
            highScore = attemptsMade;
            System.out.println("Your high score is: " + highScore);

        } else System.out.print("This is not a high score. Sorry!");
        return highScore;
    }
}










