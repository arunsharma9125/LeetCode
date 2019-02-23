package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeExample {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static TreeNode constructTree(int[] A) {
		TreeNode[] nodeArr = new TreeNode[A.length];
		for (int i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = new TreeNode(A[i]);
		}

		for (int i = 0; i < nodeArr.length; i++) {
			int j = i * 2 + 1;
			int k = i * 2 + 2;
			if (j < nodeArr.length)
				nodeArr[i].left = nodeArr[j];
			if (k < nodeArr.length)
				nodeArr[i].right = nodeArr[k];

		}
		return nodeArr[0];

	}

	static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] arr = line.split(" ");
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {

			A[i] = Integer.parseInt(arr[i]);

		}

		TreeNode root = constructTree(A);
		System.out.println("PreOrder Traversal");
		preOrder(root);
		System.out.println("PreOrder Traveersal Ends");

	}

}
