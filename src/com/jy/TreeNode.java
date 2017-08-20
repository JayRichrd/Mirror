package com.jy;

/**
 * 链表的节点
 * 
 * @author jiangyu
 *
 */
public class TreeNode {
	// 数值
	public int mValue;
	// 左子节点
	public TreeNode mLeft;
	// 右子节点
	public TreeNode mRight;

	public TreeNode(int mValue, TreeNode mLeft, TreeNode mRight) {
		super();
		this.mValue = mValue;
		this.mLeft = mLeft;
		this.mRight = mRight;
	}

}
