package com.jy;

import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) {
		// 构建树
		TreeNode treeANode1 = new TreeNode(5, null, null);
		TreeNode treeANode2 = new TreeNode(7, null, null);
		TreeNode treeANode3 = new TreeNode(9, null, null);
		TreeNode treeANode4 = new TreeNode(11, null, null);
		TreeNode treeANode5 = new TreeNode(6, treeANode1, treeANode2);
		TreeNode treeANode6 = new TreeNode(10, treeANode3, treeANode4);
		TreeNode root = new TreeNode(8, treeANode5, treeANode6);

		System.out.print("源树的广度优先遍历的结果：");
		breadthFirstTraverse(root);
		System.out.println();
		System.out.print("源树的先序遍历：");
		preOrderTraverse(root);

		System.out.println();
		// 两次镜像树又变回原来的树
		mirror(root);
		mirrorRecursively(root);
		System.out.print("源树广度优先遍历的结果：");
		breadthFirstTraverse(root);
		System.out.println();
		System.out.print("源树先序遍历：");
		preOrderTraverse(root);

	}

	/**
	 * 使用递归的方式制作树的镜像树
	 * 
	 * @param root
	 *            源树的根节点
	 */
	public static void mirrorRecursively(TreeNode root) {
		// 鲁棒性检查
		if (root == null || (root.mLeft == null && root.mRight == null))
			return;
		// 交换左右子树
		TreeNode tempNode = root.mLeft;
		root.mLeft = root.mRight;
		root.mRight = tempNode;
		// 递归交换左右子树
		mirrorRecursively(root.mLeft);
		mirrorRecursively(root.mRight);
	}

	/**
	 * 使用非递归的方式来制作树的镜像树
	 * 
	 * @param root
	 *            源树的根节点
	 */
	public static void mirror(TreeNode root) {
		// 鲁棒性检查
		if (root == null || (root.mLeft == null && root.mRight == null))
			return;
		// 使用队列
		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		// 循环交换左右子树，直到队列为空
		while (!queue.isEmpty()) {
			// 队列的头元素出对
			TreeNode treeNode = queue.poll();
			// 交换当前节点的左右子树
			TreeNode temp = treeNode.mLeft;
			treeNode.mLeft = treeNode.mRight;
			treeNode.mRight = temp;
			// 将左右子树继续加入队列
			if (treeNode.mLeft != null)
				queue.offer(treeNode.mLeft);
			if (treeNode.mRight != null)
				queue.offer(treeNode.mRight);
		}

	}

	/**
	 * 广度优先遍历树
	 * 
	 * @param root
	 *            待遍历的树
	 */
	public static void breadthFirstTraverse(TreeNode root) {
		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		if (root != null)
			// 将根节点加入队列中
			queue.offer(root);
		while (!queue.isEmpty()) {
			// 获取队列的头元素
			System.out.print(queue.peek().mValue + " ");
			// 将队列的头元素出队列
			TreeNode treeNode = queue.poll();
			// 继续将左右子节点入队
			if (treeNode.mLeft != null)
				queue.offer(treeNode.mLeft);
			if (treeNode.mRight != null)
				queue.offer(treeNode.mRight);
		}
	}

	/**
	 * 先序遍历树
	 * 
	 * @param root
	 *            待遍历的树
	 */
	public static void preOrderTraverse(TreeNode root) {
		if (root != null) {
			System.out.print(root.mValue + " ");
			// 递归
			if (root.mLeft != null)
				preOrderTraverse(root.mLeft);
			if (root.mRight != null)
				preOrderTraverse(root.mRight);
		}
	}

}
