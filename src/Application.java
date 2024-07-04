import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        if (args.length > 0) {
            // Process command-line arguments if provided
            processArgs(args);
        } else {
            // No command-line arguments, prompt the user for input
            Scanner scanner = new Scanner(System.in);
            while (true) {
                // Prompt the user for an operation or 'exit' to quit
                System.out.println("Enter operation (e.g., add, subtract, multiply, divide, factorial) or 'exit' to quit:");
                String operation = scanner.next();
                if (operation.equalsIgnoreCase("exit")) {
                    // Exit the loop and terminate the program
                    break;
                }
                // Process the user's input operation
                processOperation(operation, scanner);
            }
        }
    }

    // Processes the command-line arguments.

    private static void processArgs(String[] args) {
        // Check if the number of arguments is sufficient
        if (args.length < 3) {
            System.out.println("Insufficient arguments. Usage: <operation> <operand1> <operand2>");
            return;
        }

        // Parse the operation and operands from the arguments
        String operation = args[0];
        double num1 = Double.parseDouble(args[1]);
        double num2 = Double.parseDouble(args[2]);

        // Perform the operation based on the provided arguments
        switch (operation.toLowerCase()) {
            case "add":
                System.out.println("Result: " + add(num1, num2));
                break;
            case "subtract":
                System.out.println("Result: " + subtract(num1, num2));
                break;
            case "multiply":
                System.out.println("Result: " + multiply(num1, num2));
                break;
            case "divide":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    System.out.println("Result: " + divide(num1, num2));
                }
                break;
            case "factorial":
                System.out.println("Result: " + factorial(num1));
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    // Processes the user's input operation.
    private static void processOperation(String operation, Scanner scanner) {
        switch (operation.toLowerCase()) {
        	// add first and second operand
            case "add":
                // Prompt for and read the operands
                System.out.println("Enter the first operand:");
                double num1 = scanner.nextDouble();
                System.out.println("Enter the second operand:");
                double num2 = scanner.nextDouble();
                // Perform the addition and display the result
                System.out.println("Result: " + add(num1, num2));
                break;
            // subtract first operand by second
            case "subtract":
                System.out.println("Enter the first operand:");
                double subNum1 = scanner.nextDouble();
                System.out.println("Enter the second operand:");
                double subNum2 = scanner.nextDouble();
                System.out.println("Result: " + subtract(subNum1, subNum2));
                break;
            // multiply first operand by second
            case "multiply":
                System.out.println("Enter the first operand:");
                double mulNum1 = scanner.nextDouble();
                System.out.println("Enter the second operand:");
                double mulNum2 = scanner.nextDouble();
                System.out.println("Result: " + multiply(mulNum1, mulNum2));
                break;
            // divide first operand by second
            case "divide":
                System.out.println("Enter the first operand:");
                double divNum1 = scanner.nextDouble();
                System.out.println("Enter the second operand:");
                double divNum2 = scanner.nextDouble();
                if (divNum2 == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    System.out.println("Result: " + divide(divNum1, divNum2));
                }
                break;
            // take factorial of given number
            case "factorial":
                System.out.println("Enter a number:");
                double number = scanner.nextDouble();
                System.out.println("Result: " + factorial(number));
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    //Adds two numbers.
    public static double add(double a, double b) {
        return a + b;
    }

    //Subtracts the second number from the first number.
    public static double subtract(double a, double b) {
        return a - b;
    }


     //Multiplies two numbers.
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Divides the first number by the second number.
    public static double divide(double a, double b) {
        return a / b;
    }

   
    //Computes the factorial of a number using recursion.
    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
