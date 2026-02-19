
package edu.ilstu;

/**
 * BinTreeNode class that holds the variables for the Expression tree to use.
 * 
 * @author Brad Wickert
 */
public class BinTreeNode 
{
	
	//Initialize public variables for BinTreeNode class.
	public boolean isOperator;
	public char symbol;
	public int value;
	public BinTreeNode left;
	public BinTreeNode right;
	
	//Blank constructor.
	public BinTreeNode()
	{
		
	}
	
	//Parameter filled BinTreeNode constructor.
	public BinTreeNode(boolean isOperator, char symbol, int value)
	{
		this.isOperator = isOperator;
		this.symbol = symbol;
		this.value = value;
	}
	
	//Parameter filled BinTreeNode constructor that is used when no numbers are being used, only symbols.
	public BinTreeNode(boolean isOperator, char symbol)
	{
		this.isOperator = isOperator;
		this.symbol = symbol;
		
		//Value is set to zero since there is no number.
		this.value = 0;
	}
	
	//BinTreeNode constructor used when no symbols are used, only numbers.
	public BinTreeNode(int value)
	{
		this.isOperator = false;
		this.value = value;
	}


}
