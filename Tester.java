package edu.ilstu;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Tester class that contains the main where the user inputs their variables for the Expression tree to be made. All validity checks happen here as well.
 * 
 * @author Brad Wickert
 */
public class Tester 
{
	public static void main(String[] args) 
	{
		//Initialize the ExpressionTree object now, so it can be changed and checked for validity later.
		ExpressionTree expressionTree = null;
		
		//Initialize isValid boolean and Scanner. 
		boolean isValid = false;
		Scanner scanner = new Scanner(System.in);
		
		//Loop user input until user input is valid.
		while(!isValid)
		{
			System.out.println("Please type an arithmetic expression: ");
	        String postfix = scanner.nextLine();

	        try
	        {
	        	expressionTree = new ExpressionTree(postfix);
	        	
	        	//isValid is set to true here because if the input is invalid, it will be changed to false in the desired catch.
	        	isValid = true;
	        	
	        }
	        
	        //If the user input has invalid characters or isn't separated by spaces...
	        catch(NumberFormatException e)
	        {
	        	//The while loop restarts.
	        	System.out.println("Only numbers and operators (+, -, *, and /) seperated by spaces are valid inputs.\nPlease try again.");
	        	isValid = false;
	        }
	        
	        //If the user input has the wrong number of operators and operands...
	        catch(EmptyStackException e)
	        {
	        	//The while loop restarts.
	        	System.out.println("Number of operators and operands are not equal.\nPlease try again.");
	        	isValid = false;
	        }
	        
	        //If the user input nothing...
	        catch(StringIndexOutOfBoundsException e)
	        {
	        	//The while loop restarts.
	        	isValid = false;
	        }
	        
	        
		}
        
		//Print all info about the ExpressionTree when the while loop is exited and closes the Scanner.
        System.out.println("Prefix: " + expressionTree.getPrefixNotation().trim());
        System.out.println("Infix: " + expressionTree.getInfixNotation());
        System.out.println("Result: " + expressionTree.getValue());
        scanner.close();
    }

}
