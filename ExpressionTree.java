package edu.ilstu;

import java.util.Stack;

/**
 * ExpressionTree class that builds the Expression tree using the Stack class.
 * 
 * @author Brad Wickert
 */
public class ExpressionTree 
{
	//Initialize BinTreeNode root for this class.
	private BinTreeNode root;
	
	//ExpressionTree constructor that starts the tree building process for it by calling makeExpTree.
	public ExpressionTree(String postfix)
	{
		root = makeExpTree(postfix);
	}
	
	//makeExpTree method that builds the expression tree.
	private BinTreeNode makeExpTree(String postfix)
	{
		//Initialize a Stack of type BinTreeNode.
		Stack<BinTreeNode> stack = new Stack<>();
		
		//Initialize a String array that splits each character or number before empty space into its own String.
		String[] splitter = postfix.split(" ");
		
		//For loop that runs for each String in the splitter String array.
		for(int i = 0; i < splitter.length; i++)
		{
			//Makes a temp String that holds the current String of the splitter array at index i.
			String temp = splitter[i];
			
			//Checks if there is an operator or not.
			if(operatorCheck(temp.charAt(0)))
			{
				BinTreeNode node = new BinTreeNode(true, temp.charAt(0));
				node.right = stack.pop();
				node.left = stack.pop();
				stack.push(node);
			}
			else
			{
				BinTreeNode tempNode = new BinTreeNode(Integer.parseInt(temp));
				stack.push(tempNode);
			}
			
		}
		
		return stack.pop();
	}
	
	//operatorCheck method that I made that returns true if the char found in the parameter is an operator.
	private boolean operatorCheck(char temp)
	{
		if(temp == '+' || temp == '-' || temp == '*' || temp == '/')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//getPrefixNotation method that calls another prefixNotation getter with a parameter of type BinTreeNode.
	public String getPrefixNotation()
	{
		return getPrefixNotation(root);
	}
	
	//getPrefixNotation method with BinTreeNode parameter that returns the String format of the prefix notation.
	private String getPrefixNotation(BinTreeNode node)
	{	
		//Checks if the node is an operator or not.
        if (node.isOperator) 
        {
        	String temp = node.symbol + " " + getPrefixNotation(node.left) + getPrefixNotation(node.right);
            return temp;
        } 
        else 
        {
            return node.value + " ";
        }
	}
	
	//getInfixNotation method that calls another infixNotation getter with a parameter of type BinTreeNode.
	public String getInfixNotation()
	{
		return getInfixNotation(root);
	}
	
	//getInfixNotation method with BinTreeNode parameter that returns the String format of the infix notation.
	private String getInfixNotation(BinTreeNode node)
	{
		//Checks if the node is an operator or not.
		if(node.isOperator)
		{
			String temp = "(" + getInfixNotation(node.left) + " " + node.symbol + " " + getInfixNotation(node.right) + ")";
			return temp;
		}
		else
		{
			String temp = "" + node.value;
			return temp;
		}
	}
	
	//getValue method that calls calculateValues with a BinTreeNode type parameter.
	public int getValue()
	{
		return calculateValues(root);
	}
	
	//calculateValues method that checks the nodes symbol and calculates values based on that.
	private int calculateValues(BinTreeNode node)
	{
		//Also check if the node is an operator.
		if(!(node.isOperator))
		{
			return node.value;
		}
		
		//Initialize the left and right nodes to calculate values.
		int leftVal = calculateValues(node.left);
		int rightVal = calculateValues(node.right);
		
		
		//If statements that calculate based on the operator found.
		if(node.symbol == '+')
		{
			return leftVal + rightVal;
		}
		else if(node.symbol == '-')
		{
			return leftVal - rightVal;
		}
		else if(node.symbol == '*')
		{
			return leftVal * rightVal;
		}
		else if(node.symbol == '/')
		{
			return leftVal / rightVal;
		}
		else
		{
			//This zero will never be returned since the validity check in the Tester class will not let this method be called if any other symbol is entered.
			//This is just so there's no error so the program can launch, since an integer needs to be returned.
			return 0;
		}
		
	}
}
	