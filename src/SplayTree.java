import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*class Node{
	int data;
	Node parent;
	Node left; 
	Node right; 

	public Node(int data)
	{
		this.data = data;
		parent = null;
		left = null;
		right = null;
	}
}*/


public class SplayTree
{
	private Node root;

	public SplayTree()
	{
		root = null;
	}


	

	private void searchYesNo(Node node, int key)
	{
		while(node != null)
    	{
        	if(key == node.data)
        	{
            	searchSuccess(node, key);
            	return;
        	}
        	
			else if(key < node.data)
        	{
            	node = node.left;
        	}
        	
			else
        	{
            	node = node.right;
        	}
    	}
    	
		NoNode(key);

	}



	private Node searchSuccess(Node node, int key)
	{
		Splay(node);
		//System.out.println("Key was found: " + node.data);
		return node;
	}



	private void Deleter(Node node, int key) {
		Node deletekey = null;
		Node rightSubTree = null; 
		Node leftSubTree = null;
		while (node != null){
			if(node.data == key)
			{
				deletekey = node;
			}

			if(node.data < key)
			{
				node = node.right;
			}
			
			else
			{
				node = node.left;
			}
			
			
		}

		if(deletekey == null)
		{
			//System.out.println("Key wasn't found. Nothing to delete");
			return;
		}
		
		Splay(deletekey);
		if (deletekey.right != null)
		{
			rightSubTree = deletekey.right;
			rightSubTree.parent = null;
		}
		
		else
		{
			rightSubTree = null;
		}
		
		leftSubTree = deletekey;
		
		leftSubTree.right = null;
		deletekey = null;
		
		// remove x
		if(leftSubTree.left != null)
		{ 
			leftSubTree.left.parent = null;
		}
		
		root = joiningTrees(leftSubTree.left, rightSubTree);
		//System.out.println("Key was found and successfully deleted: " + key);

	}


	
	private void leftRotate(Node currNode)
	{
		Node y = currNode.right;
		currNode.right = y.left;

		if (y.left != null)
		{
			y.left.parent = currNode;
		}
		y.parent = currNode.parent;
		//////
		if(currNode.parent == null)
		{
			this.root = y;
		}
		
		else if(currNode == currNode.parent.left)
		{
			currNode.parent.left = y;
		}
		
		else
		{
			currNode.parent.right = y;
		}
		
		y.left = currNode;
		currNode.parent = y;

	}


	
	private void rightRotate(Node currNode)
	{
		Node y = currNode.left;
		currNode.left = y.right;

		if(y.right != null)
		{
			y.right.parent = currNode;
		}
		y.parent = currNode.parent;
		
		if(currNode.parent == null)
		{
			this.root = y;
		}

		else if(currNode == currNode.parent.right)
		{
			currNode.parent.right = y;
		}
		
		else
		{
			currNode.parent.left = y;
		}
		
		y.right = currNode;
		currNode.parent = y;

	}



	private void Splay(Node node) {
		while (node.parent != null) {
			if(node.parent.parent == null)
			{
				if(node == node.parent.left)
				{
					rightRotate(node.parent);
				}

				else if(node == node.parent.right)
				{
					leftRotate(node.parent);
				}
			}
			
			else
			{
				// right + right rotation
				if(node == node.parent.left && node.parent == node.parent.parent.left)
				{
					rightRotate(node.parent.parent);
					
					rightRotate(node.parent);
				}

				// right + left rotation
				else if(node == node.parent.left && node.parent == node.parent.parent.right)
				{
					rightRotate(node.parent);

					leftRotate(node.parent);
				}

				// left + right rotation
				else if(node == node.parent.right && node.parent == node.parent.parent.left)
				{
					leftRotate(node.parent);

					rightRotate(node.parent);
				}

				// left + left rotation
				else if(node == node.parent.right && node.parent == node.parent.parent.right)
				{
					leftRotate(node.parent.parent);

					leftRotate(node.parent);
				}

			}
		}
	}



	public Node joiningTrees(Node leftSubTree, Node rightSubTree)
	{
		if(leftSubTree == null)
		{
			return rightSubTree;
		}

		else if(rightSubTree == null)
		{
			return leftSubTree;
		}
		
		while(leftSubTree.right != null)
		{
			leftSubTree = leftSubTree.right;
		}
		
		Node newRoot = leftSubTree;
		Splay(newRoot);
		newRoot.right = rightSubTree;
		rightSubTree.parent = newRoot;
		return newRoot;
	}



	public void search(int key)
	{
		searchYesNo(this.root, key);
	}



	public void NoNode(int key)
	{
		//System.out.println("Key wasn't found: " + key);
	}
	


	public void insert(int key)
	{
		Node node = new Node(key);
		Node y = null;
		Node currNode = this.root;

		while (currNode != null)
		{
			y = currNode;
			if(node.data < currNode.data)
			{
				currNode = currNode.left;
			} 
			
			else if(node.data > currNode.data)
			{
				currNode = currNode.right;
			}
			
			else if(node.data == currNode.data)
			{
				
				return;
			}
		}

		node.parent = y;
		if(y == null)
		{
			root = node;
		}
		
		else if(node.data < y.data)
		{
			y.left = node;
		}
		
		else
		{
			y.right = node;
		}

		Splay(node);
	}



	void delete(int data)
	{
		Deleter(this.root, data);
	}

	private void visualHelper(Node currPtr, String indent, boolean last) {
		
		if (currPtr != null) {
			System.out.print(indent);
			if (last) {
			   System.out.print("R----");
			   indent += "     ";
			} else {
			   System.out.print("L----");
			   indent += "|    ";
			}
 
			System.out.println(currPtr.data);
 
			visualHelper(currPtr.left, indent, false);
			visualHelper(currPtr.right, indent, true);
		}
	}


	
	public void Visualisation()
	{
		visualHelper(this.root, "", true);
	}

	

	private static final long MEGABYTE = 1024L * 1024L;
	
	public static long bytesToMegabytes(long bytes)
    {
		return bytes / MEGABYTE;
	}

	
	public static void main(String [] args)
	{


	SplayTree operation = new SplayTree();


		int Array[] = new int[100];
		
		int a1;
    	try
		{
    		Scanner sc = new Scanner(new File("SetNum.txt"));
    		for(int i = 0; i < 100; i++)
			{
        		a1=sc.nextInt();
				Array[i] = a1;
    		}
    	}
		                
        catch(FileNotFoundException e)
		{
        	e.printStackTrace();        
    	}
		
		

		long c1 = System.currentTimeMillis();
		
		//Runtime runtime = Runtime.getRuntime();
		//runtime.gc();
		
		
		for(int i = 0; i < 100; i++)
		{
			operation.insert(Array[i]);
		}

		
		//long memory = runtime.totalMemory() - runtime.freeMemory();
        //System.out.println("Used memory is bytes: " + memory);
        //System.out.println("Used memory is megabytes: "
        //+ bytesToMegabytes(memory));
		
		System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c1)); 

		//operation.Visualisation();
	
/*
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		
		long c = System.currentTimeMillis();
		
		operation.insert(10);
    	operation.insert(6);
    	operation.insert(1);
    	operation.insert(16);
		operation.insert(15);
		operation.insert(3);
		operation.insert(8);

		System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c));
		
		long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
        + bytesToMegabytes(memory));

		operation.Visualisation();
*/
	}

}
