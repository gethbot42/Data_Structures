/**
 * @author Todd Qualiano
 * 
 *  
 * This program accepts PostFix Expressions in the form of a String from the
 * command prompt and uses a stack to help evaluate an output.
 * 
 * The user of this program will be asked to provide the PostFix Expression
 * they want evaluated.
 */
package datastructs;

import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lab3 {

    /**
     * Helper method to main().  This method will perform a basic arithmetic
     * binary operation on two integers (which are provided as Strings) given
     * the operator (also a string). Output is a string solution to the binary
     * operation.
     * 
     * @param operand1 first operand
     * @param operand2 second operand
     * @param operator binary operator
     * @return solution to the binary operation in the form of a string
     * @throws NumberFormatException iff invalid input provided
     */
    public static String evaluatePostFixExpression(String operand1, String operand2, String operator)
            throws NumberFormatException {

        String returnVal = null;
        int op1 = Integer.parseInt(operand1);
        int op2 = Integer.parseInt(operand2);
        int op3;
        switch (operator) {
            case "+":
                op3 = op1 + op2;
                returnVal = "" + op3;
                break;
            case "-":
                op3 = op1 - op2;
                returnVal = "" + op3;
                break;
            case "*":
                op3 = op1 * op2;
                returnVal = "" + op3;
                break;
            case "/":
                op3 = op1 / op2;
                returnVal = "" + op3;
                break;
            default: // this case should be examined before this method is called, however, it is handeled again here in the event of an unforseen bug
                throw new MissingFormatArgumentException("Third parameter was not an operator");
        }// end switch

        return returnVal;
    }// end method

    /**
     * Main method prompts user to input a PostFix expression to be evaluated.
     * The solution to the PostFix expression is printed in the command prompt.
     * Exceptions will be thrown for illegal format.  This includes 
     * EmptyStackExceptions in the event an operator is read by the program
     * when the underlying stack contains less than two integers.
     * @param args the command line arguments
     * @throws MissingFormatArgumentException iff input is invalid
     */
    public static void main(String[] args) throws MissingFormatArgumentException {
        Stack<String> stack = new Stack<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("enter post fix expression: ");

        String postFix1 = scan.nextLine();
        StringTokenizer tokens = new StringTokenizer(postFix1);

        while (tokens.hasMoreTokens()) {
            String temp = tokens.nextToken();
            try {
                Integer.parseInt(temp);
                stack.push(temp);
            } catch (NumberFormatException e) {
                if (isOperator(temp)) {
                    String s1 = stack.pop();
                    String s2 = stack.pop();
                    String s3 = evaluatePostFixExpression(s2, s1, temp);
                    stack.push(s3);
                } else {
                    throw new MissingFormatArgumentException("Current token is neither an integer nor operator, therefore it is illegal.");
                } // end if else

            }// end try catch
        }// end while

        System.out.println(stack.pop());
    }// end main

    /**
     * Checks to see if the parameter char is a legal operator for a post-fix
     * expression.
     * @param c the char we are checking
     * @return true iff c is a legal operator
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Checks to see if the parameter string is a legal operator for a post-fix
     * expression.
     * @param s the string we are checking
     * @return true iff s is a legal operator
     */
    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

}//end class
