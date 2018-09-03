package com.vikram.java.innovations;

public class Node {
	private int key;
	private double data;
	private Node left;
	private Node right;
	
	public Node() {
		
	}
	
	public Node(int key, double data) {
		this.key = key;
		this.data = data;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	

}
