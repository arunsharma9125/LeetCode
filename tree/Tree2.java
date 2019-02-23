package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tree2 {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static TreeNode constructTree(int[] A) {
		TreeNode[]nodeArr = new TreeNode[A.length];
		for(int i=0; i < A.length; i++){
			nodeArr[i] = new TreeNode(A[i]);
		}
		for (int i = 0; i < A.length; i++) {
			int j = i * 2 + 1;
			int k = i * 2 + 2;
			if (j < A.length) {
				nodeArr[i].left = nodeArr[j];
			}
			if (k < A.length) {
				nodeArr[i].right = nodeArr[k];
			}
		}
		return nodeArr[0];
	}

	/*
	 * ROOT LEFT RIGHT
	 */
	static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	/*
	 * LEFT ROOT RIGHT
	 */
	static void inOrder(TreeNode root) {

		if (root != null) {

			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}

	}

	/*
	 * LEFT RIGHT ROOT
	 */
	static void postOrder(TreeNode root) {

		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}

	}
	
	static void levelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(queue.isEmpty() == false){
			TreeNode temp = queue.poll();
			System.out.println(temp.data);
			if(temp.left != null){
				queue.add(temp.left);
			}
			if(temp.right != null){
				queue.add(temp.right);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] arr = line.split(" ");
		int[] A = new int[N];
		for (int i = 0; i < arr.length; i++) {
			A[i] = Integer.parseInt(arr[i]);
		}
		TreeNode root = constructTree(A);

		System.out.println("PreOrder Traversal");
		preOrder(root);
		System.out.println("PreOrder Traveersal Ends");

		System.out.println("Inorder Traversal");
		inOrder(root);
		System.out.println("Inorder Traveersal Ends");

		System.out.println("Postorder Traversal");
		postOrder(root);
		System.out.println("Postorder Traveersal Ends");

		System.out.println("Level Traversal");
		levelOrder(root);
		System.out.println("Level Traveersal Ends");
		br.close();
	}
}
