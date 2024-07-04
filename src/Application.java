 /**
* <h1 > Application.java </h1 >
 * <p>
 * This class is designed for calculator in Java.
 * It is part of Lab 1 Exercise E.
 *</p>
 * <p> <b> Submission Date : </b> July 4 , 2024 </p>
 *
 * @author Manbir Briar
 * @version 3.0
 */

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
            	 System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial) or 'exit' to quit:");
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
        if (args.length < 2) {
            System.out.println("Insufficient arguments. Usage: <operation> <operand1> <operand2> or <operation> <operand1>");
            return;
        }
        
        // Parse the operation and operands from the arguments
        String operation = args[0];
        double num1 = Double.parseDouble(args[1]);
        
        //Perform the operation based on the provided arguments
        // If requires 2 operands 
        if (args.length == 3) {
        	
            double num2 = Double.parseDouble(args[2]);
            
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
	            case "pow":
	                System.out.println("Result: " + power(num1,num2));
	                break;
	            case "permutations":
	                System.out.println("Result: " + permutations(( int )num1,( int )num2));
	                break;  
	            default:
	                System.out.println("Invalid operation");    
	                
            	}
            //if requires 1
        	}else {
		
		        switch (operation.toLowerCase()) {
		            case "factorial":
		            	System.out.println(" Result : " + factorial (( int )num1)) ;
		                break;
		            case "sqrt":
		                System.out.println("Result: " + sqrt(num1));
		                break;
		            case "log":
		                System.out.println("Result: " + log(num1));
		                break;
		            case "log10":
		                System.out.println("Result: " + log10(num1));
		                break;
		            case "sin":
		            	num1 = Math.toRadians(num1);
		                System.out.println("Result: " + sin(num1));
		                break;
		            case "cos":
		            	num1 = Math.toRadians(num1);
		                System.out.println("Result: " + cos(num1));
		                break;
		            case "tan":
		            	num1 = Math.toRadians(num1);
		                System.out.println("Result: " + tan(num1));
		                break;
		            default:
		                System.out.println("Invalid operation");
		        }
        }
    }

    // Processes the user's input operation.
    private static void processOperation(String operation, Scanner scanner) {
        // For operations requiring two inputs
        if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") && !operation.equalsIgnoreCase("factorial")) {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

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
                    System.out.println("Result: " + divide(num1, num2));
                    break;
                case "pow":
                    System.out.println("Result: " + power(num1, num2));
                    break;
	            case "permutations":
	                System.out.println("Result: " + permutations(( int )num1,( int )num2));
	                break;  
                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        } else {
            // For operations requiring one input
            System.out.print("Enter number: ");
            double num = scanner.nextDouble();

            switch (operation.toLowerCase()) {
                case "sqrt":
                    System.out.println("Result: " + sqrt(num));
                    break;
                case "log":
                    System.out.println("Result: " + log(num));
                    break;
                case "log10":
                    System.out.println("Result: " + log10(num));
                    break;
                case "sin":
                	num = Math.toRadians(num);
                    System.out.println("Result: " + sin(num));
                    break;
                case "cos":
                	num = Math.toRadians(num);
                    System.out.println("Result: " + cos(num));
                    break;
                case "tan":
                	num = Math.toRadians(num);
                    System.out.println("Result: " + tan(num));
                    break;
                case "factorial":
                    // Factorial is a special case requiring an integer
                    System.out.println("Result: " + factorial((int)num));
                    break;
                default:
                    System.out.println("Invalid operation.");
                    break;
            }
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

    // Factorial calculation with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            System.out.print("\rCalculating factorial: 100%");
            return 1;
        }
        // Calculate progress and update progress bar
        int progress = (int) (((originalNum - num + 1) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }
    
    // Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }

    // Sine function
    public static double sin(double angleRadians) {
        return Math.sin(angleRadians);
    }

    // Cosine function
    public static double cos(double angleRadians) {
        return Math.cos(angleRadians);
    }

    // Tangent function
    public static double tan(double angleRadians) {
        return Math.tan(angleRadians);
    }
    
    // Permutations function
    public static int permutations(int totalItems, int selectedItems) {
        if (selectedItems < 0 || selectedItems > 100) {
            System.err.println("Error: Number of selected items must be between 0 and 100.");
            return -1;
        }
        if (selectedItems > totalItems) {
            System.err.println("Error: Number of selected items cannot exceed total items in the array.");
            return -1;
        }
        
        int permutation = 1;
        for (int i = totalItems; i > totalItems - selectedItems; i--) {
            permutation *= i;
        }
        return permutation;
    }
    
    // NonRecursive Permutations function
    public static int permutationsNonRecursive(int totalItems, int selectedItems) {
  
        if (selectedItems < 0 || selectedItems > 100) {
            System.err.println("Error: Number of selected items must be between 0 and 100.");
            return -1;
        }
        if (selectedItems > totalItems) {
            System.err.println("Error: Number of selected items cannot exceed total items in the array.");
            return -1;
        }
        
        int permutation = 1;
        for (int i = totalItems; i > totalItems - selectedItems; i--) {
            permutation *= i;
        }
        
        return permutation;
    }
}
