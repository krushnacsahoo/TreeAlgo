package com.test.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Component;

//Recursive optimized Java program to find the diameter of a
//Binary Tree

/* Class containing left and right child of current
node and key value*/
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}

	public void add(int data) {
		if (data < this.data) {
			if (left != null) {
				left.add(data);
			} else {
				left = new Node(data);
			}
		} else if (data > this.data) {
			if (right != null) {
				right.add(data);
			} else {
				right = new Node(data);
			}
		} else {
			// update this one
			this.data = data;
		}
	}

//	public void inOrderTraversal() {
//
//		if (this.left != null)
//			this.left.inOrderTraversal();
//		System.out.println(data);
//		if (this.right != null)
//			this.right.inOrderTraversal();
//	}

//	public void preOrderTraversal() {
//
//		System.out.println(data);
//		if (this.left != null)
//			this.left.preOrderTraversal();
//
//		if (this.right != null)
//			this.right.preOrderTraversal();
//	}
};

@Component
/* Class to print the Diameter */
public class BinaryTreeAlgoImpl implements BinaryTreeAlgo {
	Node root;

	/* Method to calculate the diameter and return it to main */
	int diameter(Node root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = height(root.left);
		int rheight = height(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter of
		 * right subtree 3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

	}

	/* A wrapper over diameter(Node root) */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.algo.tree.BinaryTreeAlgoI#diameter()
	 */
	@Override
	public int diameter() {
		return diameter(root);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.algo.tree.BinaryTreeAlgoI#height()
	 */
	@Override
	public int height() {
		/* base case tree is empty */

		return height(root);
	}

	/*
	 * The function Compute the "height" of a tree. Height is the number f nodes
	 * along the longest path from the root node down to the farthest leaf node.
	 */
	static int height(Node node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

		/*
		 * If tree is not empty then height = 1 + max of left height and right heights
		 */
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.algo.tree.BinaryTreeAlgoI#addNode(int)
	 */
	@Override
	public void addNode(int data) {
		if (null == root)
			root = new Node(data);
		else
			root.add(data);
	}

	public void inOrderTraversal() {
		if (null == root)
			return;

		
		inOrderTraversal(root);
	}

	void inOrderTraversal(Node node) {
		if (null == node)
			return;

		if (null != node.left)
			inOrderTraversal(node.left);
		System.out.println(node.data);
		if (null != node.right)
			inOrderTraversal(node.right);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.algo.tree.BinaryTreeAlgoI#preOrderTraversal()
	 */
	@Override
	public void preOrderTraversal() {
		if (null == root)
			return;

		preOrderTraversal(root);
	}

	void preOrderTraversal(Node node) {
		if (null == node)
			return;

		System.out.println(node.data);
		
		if (null != node.left)
			preOrderTraversal(node.left);
		
		if (null != node.right)
			preOrderTraversal(node.right);

	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.algo.tree.BinaryTreeAlgoI#lca(int, int)
	 */
	@Override
	public Node lca(int n1, int n2) {
		return lca(root, n1, n2);
	}

	public Node lca(Node node, int n1, int n2) {
		if (node == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (node.data > n1 && node.data > n2)
			return lca(node.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (node.data < n1 && node.data < n2)
			return lca(node.right, n1, n2);

		return node;
	}

	public void printPaths() {
		// int path[] = new int[1000];
		List<Integer> list = new ArrayList<Integer>();
		printPathsRecur(root, list, 0);
	}

	/*
	 * Recursive helper function -- given a node, and an array containing the path
	 * from the root node up to but not including this node, print out all the
	 * root-leaf paths.
	 */
	void printPathsRecur(Node node, List<Integer> arraylist, int pathLen) {
		if (node == null)
			return;

		/* append this node to the path array */
		// path[pathLen] = node.data;
		arraylist.add(pathLen, (node.data));
		pathLen++;

		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null)
			printArray(arraylist, pathLen);
		else {
			/* otherwise try both subtrees */
			printPathsRecur(node.left, arraylist, pathLen);
			printPathsRecur(node.right, arraylist, pathLen);
		}
	}

	/* Utility that prints out an array on a line */
	void printArray(List<Integer> arraylist, int len) {

		int i;
		for (i = 0; i < len; i++)
			System.out.print(arraylist.get(i) + " ");
		System.out.println("");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.algo.tree.BinaryTreeAlgoI#getLeafCount()
	 */
	@Override
	public int getLeafCount() {
		return getLeafCount(root);
	}

	int getLeafCount(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}

	public void printLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public void printGivenLevel(int level) {

		printGivenLevel(root, level);
	}

	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
}
