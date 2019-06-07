package com.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import com.algorithms.adt.BinaryTreeNode;

/**
 * Tree traversal
 *    1          PreOrderTraversal:  1 2 4 5 3 6 7
 *  2    3   =>  PostOrderTraversal: 4 5 2 6 7 3 1
 * 4 5  6 7      InorderTraversal:   4 2 5 1 6 3 7
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
public class TreeTraversal {
	public void recursivePostOrderTraversal(BinaryTreeNode root, Deque<Integer> queue) {
		if (root == null) {
			return;
		}
		recursivePostOrderTraversal(root.left, queue);
		recursivePostOrderTraversal(root.right, queue);
		queue.add(root.data);
	}
	
	public void recursivePreOrderTraversal(BinaryTreeNode root, Deque<Integer> queue) {
		if (root == null) {
			return;
		}
		queue.add(root.data);
		recursivePreOrderTraversal(root.left, queue);
		recursivePreOrderTraversal(root.right, queue);
	}
	
	public void recursiveInOrderTraversal(BinaryTreeNode root, Deque<Integer> queue) {
		if (root == null) {
			return;
		}
		recursiveInOrderTraversal(root.left, queue);
		queue.add(root.data);		
		recursiveInOrderTraversal(root.right, queue);
	}
	
	public void levelTraversal(BinaryTreeNode node) {
		Queue<BinaryTreeNode> queue = new ArrayDeque<>();
		if (node !=null) {
			queue.add(node);
		}
		
		while (!queue.isEmpty()) {
			BinaryTreeNode element = queue.poll();
			System.out.print(element.data+" ");
			if (element.left != null) {
				queue.add(element.left);
			} 
			if (element.right != null) {
				queue.add(element.right);
			}
		}
	}
	
	public void reverseLevelTraversal(BinaryTreeNode node) {
		Queue<BinaryTreeNode> queue = new ArrayDeque<>();
		Deque<BinaryTreeNode> deque = new ArrayDeque<>();
		if (node != null) {
			queue.add(node);
			deque.add(node);
		}
		
		while (!queue.isEmpty()) {
			BinaryTreeNode element = queue.poll();
			if (element.left != null) {
			 	deque.add(element.left);
			 	queue.add(element.left);
			}
			
			if (element.right != null) {
				deque.add(element.right);
			 	queue.add(element.right);
			}
		}
		
		while (!deque.isEmpty()) {
			System.out.print(deque.removeLast().data+" ");
		}
	}
}
