package com.vikram.java.innovations;

public class BinaryTree {
	
	private Node root;
	
	public BinaryTree () {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	/* Following code if from Sriram's code */
	
	//-------------------------------------------------------------
	public Node find(int key)      // find node with given key
	   {                           // (assumes non-empty tree)
	   Node current = root;               // start at root
	   while(current.getKey() != key)        // while no match,
	      {
	      if(key < current.getKey())         // go left?
	         current = current.getLeft();
	      else                            // or go right?
	         current = current.getRight();
	      if(current == null)             // if no child,
	         return null;                 // didn't find it
	      }
	   return current;                    // found it
	   }  // end find()
	//-------------------------------------------------------------
	
	public void insert(int id, double dd)
	   {
	   Node newNode = new Node();    // make new node
	   newNode.setKey(id);           // insert data
	   newNode.setData(dd);
	   if(root==null)                // no node in root
	      root = newNode;
	   else                          // root occupied
	      {
	      Node current = root;       // start at root
	      Node parent;
	      while(true)                // (exits internally)
	         {
	         parent = current;
	         if(id < current.getKey())  // go left?
	            {
	            current = current.getLeft();
	            if(current == null)  // if end of the line,
	               {                 // insert on left
	               parent.setLeft(newNode);
	               return;
	               }
	            }  // end if go left
	         else                    // or go right?
	            {
	            current = current.getRight();
	            if(current == null)  // if end of the line
	               {                 // insert on right
	               parent.setRight(newNode);
	               return;
	               }
	            }  // end else go right
	         }  // end while
	      }  // end else not root
	   }  // end insert()
	
	//-------------------------------------------------------------
	
	public boolean delete(int key) // delete node with given key
	   {                           // (assumes non-empty list)
	   Node current = root;
	   Node parent = root;
	   boolean isleft = true;
	   
	   if(current == null)             // When root is null,
	       return false;                // didn't find it

	   while(current.getKey() != key)        // search for node
	      {
	      parent = current;
	      if(key < current.getKey())         // go left?
	         {
	         isleft = true;
	         current = current.getLeft();
	         }
	      else                            // or go right?
	         {
	         isleft = false;
	         current = current.getRight();
	         }
	      if(current == null)             // end of the line,
	         return false;                // didn't find it
	      }  // end while
	   // found node to delete

	   // if no children, simply delete it
	   if(current.getLeft()==null &&
	                                current.getRight()==null)
	      {
	      if(current == root)             // if root,
	         root = null;                 // tree is empty
	      else if(isleft)
	         parent.setLeft(null);     // disconnect
	      else                            // from parent
	         parent.setRight(null);
	      }

	   // if no right child, replace with left subtree
	   else if(current.getRight()==null)
	      if(current == root)
	         root = current.getLeft();
	      else if(isleft)
	         parent.setLeft(current.getLeft());
	      else
	         parent.setRight(current.getLeft());

	   // if no left child, replace with right subtree
	   else if(current.getLeft()==null)
	      if(current == root)
	         root = current.getRight();
	      else if(isleft)
	         parent.setLeft(current.getRight());
	      else
	         parent.setRight(current.getRight());

	   else  // two children, so replace with inorder successor
	      {
	      // get successor of node to delete (current)
	      Node successor = getSuccessor(current);

	      // connect parent of current to successor instead
	      if(current == root)
	         root = successor;
	      else if(isleft)
	         parent.setLeft(successor);
	      else
	         parent.setRight(successor);

	      // connect successor to current's left child
	      successor.setLeft(current.getLeft());
	      }  // end else two children
	   // (successor cannot have a left child)
	   return true;                                // success
	   }  // end delete()
	
	//-------------------------------------------------------------
	
	// returns node with next-highest value after delNode
	// goes to right child, then right child's left descendents
	private Node getSuccessor(Node delNode)
	   {
	   Node successorParent = delNode;
	   Node successor = delNode;
	   Node current = delNode.getRight();   // go to right child
	   while(current != null)               // until no more
	      {                                 // left children,
	      successorParent = successor;
	      successor = current;
	      current = current.getLeft();      // go to left child
	      }
	                                        // if successor not
	   if(successor != delNode.getRight())  // right child,
	      {                                 // make connections
	      successorParent.setLeft(successor.getRight());
	      successor.setRight(delNode.getRight());
	      }
	   return successor;
	   }
	//-------------------------------------------------------------
	public void traverse(int traverseType)
	   {
	   switch(traverseType)
	      {
	      case 1: System.out.print("\nPreorder traversal: ");
	              preOrder(root);
	              break;
	      case 2: System.out.print("\nInorder traversal:  ");
	              inOrder(root);
	              break;
	      case 3: System.out.print("\nPostorder traversal: ");
	              postOrder(root);
	              break;
	      }
	   System.out.println();
	   }
	
	//-------------------------------------------------------------
	
	private void preOrder(Node localRoot)
	   {
	   if(localRoot != null)
	      {
	      System.out.print(localRoot.getKey() + " ");
	      preOrder(localRoot.getLeft());
	      preOrder(localRoot.getRight());
	      }
	   }
	
	//-------------------------------------------------------------
	
	private void inOrder(Node localRoot)
	   {
	   if(localRoot != null)
	      {
	      inOrder(localRoot.getLeft());
	      System.out.print(localRoot.getKey() + " ");
	      inOrder(localRoot.getRight());
	      }
	   }
	
	//-------------------------------------------------------------
	
	private void postOrder(Node localRoot)
	   {
	   if(localRoot != null)
	      {
	      postOrder(localRoot.getLeft());
	      postOrder(localRoot.getRight());
	      System.out.print(localRoot.getKey() + " ");
	      }
	   }

}
