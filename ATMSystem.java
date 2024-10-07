import java.util.ArrayList;
import java.util.Scanner;

public class ATMSystem {

    private static double balance;  // User-input initial balance
    private static ArrayList<String> miniStatement = new ArrayList<>();  // To store the transaction history

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Getting user input for ATM Pin and Initial Balance
        System.out.print("Set your ATM Pin: ");
        int pin = scanner.nextInt();
        
        System.out.print("Enter your initial account balance: ");
        balance = scanner.nextDouble();

        System.out.println("\nATM Setup Complete! Now you can perform transactions.\n");

        int enteredPin;
        int choice;

        // Asking for ATM pin each time user interacts with the system
        do {
            System.out.print("Enter ATM Pin: ");
            enteredPin = scanner.nextInt();

            if (enteredPin == pin) {
                System.out.println("Account Authorized!");

                do {
                    System.out.println("\n1. View Available Balance");
                    System.out.println("2. Withdraw Amount");
                    System.out.println("3. Deposit Amount");
                    System.out.println("4. View Mini-statement");
                    System.out.println("5. Exit");
                    System.out.print("Enter Choice: ");
                    
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            viewBalance();
                            break;
                        case 2:
                            withdrawAmount(scanner);
                            break;
                        case 3:
                            depositAmount(scanner);
                            break;
                        case 4:
                            viewMiniStatement();
                            break;
                        case 5:
                            System.out.println("Exiting... Thank you for using the ATM.");
                            break;
                        default:
                            System.out.println("Invalid choice, please try again.");
                    }
                } while (choice != 5);
            } else {
                System.out.println("Invalid PIN, please try again.");
            }
        } while (enteredPin != pin);  // Keeps asking for pin until the correct one is entered

        scanner.close();
    }

    // Function to view available balance
    private static void viewBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    // Function to withdraw amount
    private static void withdrawAmount(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount <= balance) {
            System.out.print("Confirm? Y/N: ");
            String confirm = scanner.next();

            if (confirm.equalsIgnoreCase("Y")) {
                balance -= withdrawAmount;
                System.out.println("Collect the Cash: " + withdrawAmount);
                System.out.println("Loading Account Balance...");
                System.out.println("Your Current Balance is: " + balance);
                miniStatement.add("Withdrawn: " + withdrawAmount);
            } else {
                System.out.println("Withdrawal Cancelled.");
            }
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Function to deposit amount
    private static void depositAmount(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();

        balance += depositAmount;
        System.out.println("Amount deposited successfully.");
        System.out.println("Your Current Balance is: " + balance);
        miniStatement.add("Deposited: " + depositAmount);
    }

    // Function to view mini-statement
    private static void viewMiniStatement() {
        System.out.println("\n--- Mini Statement ---");
        if (miniStatement.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : miniStatement) {
                System.out.println(transaction);
            }
        }
        System.out.println("-----------------------");
    }
}