import java.util.InputMismatchException;
import java.util.Scanner;

// Medium Level: ATM Withdrawal System
class ATM {
    private static final int PIN = 1234;
    private double balance = 3000.0;

    public void withdraw(double amount, int enteredPin) {
        try {
            if (enteredPin != PIN) {
                throw new SecurityException("Invalid PIN.");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } catch (SecurityException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Current Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            atm.withdraw(amount, enteredPin);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}