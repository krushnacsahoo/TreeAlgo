package com.test.algo.tree;

public interface BinaryTreeAlgo {

	int diameter();

	int height();

	void addNode(int data);

	void preOrderTraversal();

	void inOrderTraversal();

	Node lca(int n1, int n2);

	int getLeafCount();

	void printPaths();

	void printLevelOrder();

	void printGivenLevel(int leval);

}