package com.test.algo.tree;

public class BinaryTreeAppMain {

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		
		BinaryTreeAlgo tree =  new BinaryTreeAlgoImpl();
		tree.addNode(11);
		tree.addNode(5);
		tree.addNode(12);
		tree.addNode(21);
		tree.addNode(14);
		tree.addNode(2);
		tree.addNode(4);
		tree.addNode(6);
		tree.addNode(31);

		System.out.println("InOrder traversal");
		System.out.println("---------------------");
		tree.inOrderTraversal();
		System.out.println("PreOrder traversal");
		System.out.println("---------------------");
		tree.preOrderTraversal();

		System.out.println("The diameter of given binary tree is : " + tree.diameter());
		System.out.println("---------------------");

		Node node = tree.lca(4, 6);
		System.out.println("LCA of 4 & 6: " + node.data);

		System.out.println("-----Tree all Path----------------");
		tree.printPaths();

		System.out.println("-----Tree Leaf node count----------------");
		System.out.println("Leaf Node Count : " + tree.getLeafCount());
		
		System.out.println("-----Tree Height ----------------");
		System.out.println("Tree height : " + tree.height());
		
		System.out.println("-----Tree BST print level wise ----------------");
		tree.printLevelOrder();
		System.out.println("-----Tree BST print level wise ----------------");
		tree.printGivenLevel(3);

	}
}
