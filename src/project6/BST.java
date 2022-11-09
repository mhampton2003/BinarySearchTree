package project6;

public class BST {
	
	//Node class
	static class Node {
		String key;
		Node left;
		Node right;
		
		//Node non default constructor
		public Node(String data){
			key = data;
			left = right = null;
		}
	}
	
	Node root;
	int counter;
	
	//BST non default constructor
	public BST() {
		this.root = null;
	}
	
	//inserts data into tree
	public void newInsert(String data) {
		root = insert(root, data);
	}
	
	//helper insert
	public Node insert(Node root, String data) {
		
		if (root == null) {
			root = new Node(data);
			return root;
		}
		
		//if data is less than root data move through left side
		if (data.compareTo(root.key) < 0) {
			root.left = insert(root.left, data);
		}
		
		//if data is more than root data move through right side
		else if (data.compareTo(root.key) > 0) {
			root.right = insert(root.right, data);
		}
		
		else {
			//do nothing
		}
		
		return root;
	}
	
	//displays tree data
	public void displayInOrder() {
		display(root);
	}
	
	//helper display
	public void display(Node root) {
		//prints out data using LPR (Left Print Right) algorithm
		if (root != null) {
			display(root.left);
			System.out.print(root.key + " ");
			display(root.right);
		}
	}
	
	//helper search
	public Node search(Node inRoot, String input) {
		
		//if current data is null or is found return the data
		if (inRoot == null || inRoot.key.equals(input)) {
			counter++;
			return inRoot;
		}
		
		//search through left half of tree if data is less than root data
		if (inRoot.key.compareTo(input) > 0) {
			counter++;
			return search(inRoot.left, input);
		}
		
		//search through right half of tree if data is more than root data
		if (inRoot.key.compareTo(input) < 0) {
			counter++;
			return search(inRoot.right, input);
		}
		
		return inRoot;
	}
	
	//searches through tree to find data
	public boolean returnSearch(String input) {
		counter = 0;
		Node newroot = search(root, input);
		
		//if data was found return true
		if (newroot != null) {
			return true;
		}
		
		return false;
	}
	
	//delete helper
	public String minVal(Node root) {
		String minVal = root.key;
		
		//moves through left side of tree to find smallest value
		while (root.left != null) {
			root = root.left;
		}
		
		minVal = root.key;
		
		return minVal;
	}
	
	//deletes data from tree
	public void returnDelete(String input) {
		Node newroot = delete(root, input);
	}
	
	//delete helper
	public Node delete(Node inRoot, String input) {

		//if current data is null tree is empty
		if (inRoot == null) {
			return inRoot;
		}
		
		//if data is less than current data iterate through left half of tree
		if (inRoot.key.compareTo(input) > 0) {
			inRoot.left = delete(inRoot.left, input);
		}
		
		//if data is more than current data iterate through right half of tree
		else if (inRoot.key.compareTo(input) < 0) {
			inRoot.right = delete(inRoot.right, input);
		}
		
		//if the found data has no children then remove current data
		else if (inRoot.left == null && inRoot.right == null) {
			return inRoot.left;
		}
		
		//if the found data has a single child to the right then it replaces itself with the right child
		else if (inRoot.left == null && inRoot.right != null) {
			return inRoot.right;
		}
		
		//if the found data has a single child to the left then it replaces itself with the left child
		else if (inRoot.right == null && inRoot.left != null) {
			return inRoot.left;
		}
		
		//if the found data has two children then it finds the smallest value on the right sideto replace itself with
		else if (inRoot.right != null && inRoot.left != null) {
			inRoot.key = minVal(inRoot.right);
			inRoot.right = delete(inRoot.right, inRoot.key);
		}
		
		return inRoot;
	}
	
}
