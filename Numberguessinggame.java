import java.util.Scanner;

public class Numberguessinggame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secretNumber = 79; 
        int turnsLeft = 5;
        int guess;
        int lowerBound = 1;
        int upperBound = 100;

        System.out.println("NEW GAME");
        System.out.println("Pick a number between 1-100! You will get 5 turns");

        while (turnsLeft > 0) {
            // System.out.print("pick a number between " + lowerBound + " - " + upperBound + ": ");
            guess = scanner.nextInt();
            System.out.println("player guesses "+guess);
            if (guess == secretNumber) {
                System.out.println("YOU WIN! The SECRET number was " + secretNumber);
                break;
            } else if (guess < secretNumber) {
                System.out.println("Sorry, that is too low");
                lowerBound = guess + 1;
            } else {
                System.out.println("Sorry, that is too high");
                upperBound = guess - 1;
            }

            turnsLeft--;
            if (turnsLeft > 0) {
                System.out.println("Pick a number between " + lowerBound + "-" + upperBound + " and turns left " + turnsLeft);
            } else {
                System.out.println("GAME OVER! The secret number was " + secretNumber);
            }
        }
        
        scanner.close();
    }
}