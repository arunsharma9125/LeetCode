package tree;

public class Tree1 {

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
		
		if(root!=null){
			
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}

	}

	/*
	 * LEFT RIGHT ROOT
	 */
	static void postOrder(TreeNode root) {
		
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}

	}

	public static void main(String []args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(8);

		System.out.println("PreOrder Traversal");
		preOrder(root);
		System.out.println("PreOrder Traveersal Ends");

		System.out.println("Inorder Traversal");
		inOrder(root);
		System.out.println("Inorder Traveersal Ends");

		System.out.println("Postorder Traversal");
		postOrder(root);
		System.out.println("Postorder Traveersal Ends");
	}
}
