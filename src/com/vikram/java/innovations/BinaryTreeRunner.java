package com.vikram.java.innovations;

public class BinaryTreeRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();
		

		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		
		boolean balanced = theTree.isBalanced(theTree.getRoot());
		
		if (balanced)
			System.out.println("The tree is balanced!!!");
		else
			System.out.println("The tree is not balanced.");
		/* The above binary tree is not balanced. Hence, let us add 
		 * few nodes to balance it */
			
		theTree.insert(6, 0.5);
		theTree.insert(86, 1.4);
		theTree.insert(66, 1.2);
		theTree.insert(60, 1.1);
		
		balanced = theTree.isBalanced(theTree.getRoot());
		
		if (balanced)
			System.out.println("The tree is balanced!!!");
		else
			System.out.println("The tree is not balanced.");
		/* This is balanced binary tree. */

	}

}
