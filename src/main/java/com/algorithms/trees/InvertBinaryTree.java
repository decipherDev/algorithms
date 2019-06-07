package com.algorithms.trees;

import com.algorithms.adt.BinaryTreeNode;
/**
 * Inverts a binary tree
 *    1             1
 *  2    3   =>   3     2
 * 4 5  6 7     7   6  5   4
 *
 * 
 * Uses below class as BinaryTree definition
 * 
 * public class BinaryTreeNode {
 *     public Integer data;
 *     public BinaryTreeNode left;
 *     public BinaryTreeNode right;
 *
 *     public BinaryTreeNode(Integer data, BinaryTreeNode left, BinaryTreeNode right) {
 *         this.data = data;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 */
public class InvertBinaryTree {
	public void invertABinaryTree(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		
		BinaryTreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertABinaryTree(root.left);
		invertABinaryTree(root.right);
	}
}
