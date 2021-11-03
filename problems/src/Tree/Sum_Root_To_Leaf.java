package Tree;

/*
    Problem breakdown - Find the sum of all numbers which are formed from root to leaf nodes
    

    Solution breakdown - Preorder traversal
                       - if(node is leaf)
                                Add it to the number formed till and sum it up
                       - else
                                traverse(node.left, StringBuilder)


*/
class Sum_Root_To_Leaf {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int result = 0;

	public int sumNumbers(TreeNode root) {

		helper(root, 0);

		return result;
	}

	public void helper(TreeNode root, int current)
	{

		//Leaf Node is reached. Convert the string to sum and add them to result
		if(root !=  null)
		{
			current = current * 10 + root.val;
			if(root.left == null && root.right == null)
			{
				result += current;
			}

			helper(root.left, current);

			helper(root.right, current);
		}
	}
}