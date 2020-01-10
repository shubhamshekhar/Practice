public class BST 
{
	Node root;

	public static class Node
	{
		int data;
		Node left,right;
		Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static BST insert(BST tree, int data)
	{
		if (tree.root==null)
		{
			tree.root = new Node(data);
		}
		else if(tree.root.data>data){
			tree.root.left = insertChildIntoBST(tree.root.left,data);
		}
		else{
			tree.root.right = insertChildIntoBST(tree.root.right,data);
		}
		return tree;
	}

	public static Node insertChildIntoBST(Node node,int data)
	{
		if(node==null)
		{
			Node newNode = new Node(data);
			node = newNode;
		}
		else if(node.data>data)
		{
			node.left = insertChildIntoBST(node.left,data);
		}
		else
			node.right = insertChildIntoBST(node.right,data);
		return node;

	}

	public static void preOrder(Node node)
	{
		if (node != null)
		{
			preOrder(node.left);
			System.out.print("->"+node.data);
			preOrder(node.right);
		}
	}


	public static void main(String[] args)
	{
		BST bst = new BST();

		bst = insert(bst,10);
		bst = insert(bst,8);
		bst = insert(bst,1);
		bst = insert(bst,0);
		bst = insert(bst,14);
		bst = insert(bst,10);
		bst = insert(bst,4);
		bst = insert(bst,18);
		bst = insert(bst,19);
		bst = insert(bst,17);

		preOrder(bst.root);
		System.out.println();

	}
}
