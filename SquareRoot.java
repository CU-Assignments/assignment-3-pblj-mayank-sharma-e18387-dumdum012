import java.util.InputMismatchException;
import java.util.Scanner;

// Easy Level: Square Root Calculation
class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();
            if (num < 0) {
                throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
            }
            System.out.println("Square Root: " + Math.sqrt(num));
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
