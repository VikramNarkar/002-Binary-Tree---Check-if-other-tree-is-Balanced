package com.vikram.java.innovations;

public class CheckForBalanced {
	
	private BinaryTree tree;
	
	public CheckForBalanced (BinaryTree tree) {
		this.tree = tree;
	}
	
	

	public boolean isBinarySearchTree(BinaryTree tree) {
		/*IsHeightBalanced(tree)
	    return (tree is empty) or 
	           (IsHeightBalanced(tree.left) and
	            IsHeightBalanced(tree.right) and
	            abs(Height(tree.left) - Height(tree.right)) <= 1)*/
		
		return true;
	}

}
