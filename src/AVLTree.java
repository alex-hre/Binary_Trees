import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Node
{
	int data;
	Node parent;
	Node left;
	Node right;
	int balancefactor;

	public Node(int data)
	{
		this.data = data;
		parent = null;
		left = null;
		right = null;
		balancefactor = 0;
	}

        
}



public class AVLTree
{
	private Node root;



	public AVLTree()
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



	public void NoNode(int key)
	{
		System.out.println("Key wasn't found: " + key);
	}



	private Node searchSuccess(Node node, int key)
	{
		System.out.println("Key was found: " + node.data);
		return node;
	}



	private Node Deleter(Node node, int key)
	{
		if(node == null)
		{
			return node;
		}
		
		else if(key < node.data)
		{
			node.left = Deleter(node.left, key);
		} 
		
		else if(key > node.data)
		{
			node.right = Deleter(node.right, key);
		}
		
		else
		{
			if(node.left == null && node.right == null)
			{
				node = null;
			}
			
			else if(node.left == null)
			{
				if(node.parent == null)
				{	
					node = node.right;
					root = node;
				}

				else
				{
					node = node.right;
				}
					
			}

			else if(node.right == null)
			{
				if(node.parent == null)
				{	
					node = node.left;
					root = node;
				}
				
				else
				{
					node = node.left;
				}
				//
			}

			// have l & r children
			else
			{
				Node temp = minimum(node.right);
				node.data = temp.data;

				
				
				node.right = Deleter(node.right, temp.data);	
			}
			
			//
			//System.out.println("Key was found and successfully deleted");
			
		} 
		
		return node;
	}

	

	private void updateBalance(Node node)
	{
		if(node.balancefactor < -1 || node.balancefactor > 1)
		{
			rebalance(node);
			return;
		}

		if(node.parent != null)
		{
			if(node == node.parent.left)
			{
				node.parent.balancefactor -= 1;
			} 

			if(node == node.parent.right)
			{
				node.parent.balancefactor += 1;
			}

			if(node.parent.balancefactor != 0)
			{
				updateBalance(node.parent);
			}
		}
	}



	void rebalance(Node node)
	{
		if (node.balancefactor > 0)
		{
			if(node.right.balancefactor < 0)
			{
				rightRotate(node.right);
				leftRotate(node);
			}
			
			else
			{
				leftRotate(node);
			}
		}

		else if(node.balancefactor < 0)
		{
			if(node.left.balancefactor > 0)
			{
				leftRotate(node.left);
				rightRotate(node);
			}
			
			else
			{
				rightRotate(node);
			}
		}
	}

	//
	//
	//
	
	public void search(int k)
	{
		searchYesNo(this.root, k);
	}



	public Node minimum(Node node)
	{
		while(node.left != null)
		{
			node = node.left;
		}
		return node;
	}



	void leftRotate(Node x)
	{
		Node y = x.right;
		x.right = y.left;

		if (y.left != null)
		{
			y.left.parent = x;
		}
		y.parent = x.parent;
		//////
		if(x.parent == null)
		{
			this.root = y;
		}
		
		else if(x == x.parent.left)
		{
			x.parent.left = y;
		}
		
		else
		{
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;

		//
		x.balancefactor = x.balancefactor - 1 - Math.max(0, y.balancefactor);
		y.balancefactor = y.balancefactor - 1 + Math.min(0, x.balancefactor);
	}



	void rightRotate(Node x)
	{
		Node y = x.left;
		x.left = y.right;

		if(y.right != null)
		{
			y.right.parent = x;
		}
		y.parent = x.parent;
		/////
		if(x.parent == null)
		{
			this.root = y;
		}

		else if(x == x.parent.right)
		{
			x.parent.right = y;
		}
		
		else
		{
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;

		//update balance
		x.balancefactor = x.balancefactor + 1 - Math.min(0, y.balancefactor);
		y.balancefactor = y.balancefactor + 1 + Math.max(0, x.balancefactor);
	}

	public void insert(int key)
	{
		Node node = new Node(key);
		Node y = null;
		Node x = this.root;

		while (x != null)
		{
			y = x;
			if(node.data < x.data)
			{
				x = x.left;
			} 
			
			else if(node.data > x.data)
			{
				x = x.right;
			}
			
			else if(node.data == x.data)
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
		
		updateBalance(node);
	}

	Node delete(int data)
	{
		return Deleter(this.root, data);
	}

	private void VisualHelper(Node currPtr, String indent, boolean last) {
		
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

		   VisualHelper(currPtr.left, indent, false);
		   VisualHelper(currPtr.right, indent, true);
		}
	}

	public void Visualisation()
	{
		VisualHelper(this.root, "", true);
	}

	private static final long MEGABYTE = 1024L * 1024L;
	
	public static long bytesToMegabytes(long bytes)
    {
		return bytes / MEGABYTE;
	}

	public static void main(String [] args)
	{
		
		AVLTree operation = new AVLTree();
  		
		
		
		
		//Runtime runtime = Runtime.getRuntime();
		//runtime.gc();
		
/*	

		
		int[] Array = new int[10000];
		int a1;
    	try
		{
    		Scanner sc = new Scanner(new File("SetNum.txt"));
    		for(int i = 0; i < 10000; i++)
			{
        		a1=sc.nextInt();
				Array[i] = a1;
    		}
    	}
		                
        catch(FileNotFoundException e)
		{
        	e.printStackTrace();        
    	}
		
		
		
		
		long c = System.currentTimeMillis();
		
		for(int i = 0; i < 10000; i++)
		{
			operation.insert(Array[i]);
    	}

		for(int i = 0; i < 10000/2; i++)
		{
			operation.delete(Array[i]);
    	}

		for(int i = 0; i < 10000/2; i++)
		{
			operation.search(Array[i]);
    	}
		
		System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c));
*/
		//long memory = runtime.totalMemory() - runtime.freeMemory();
        //System.out.println("Used memory is bytes: " + memory);
        //System.out.println("Used memory is megabytes: "
        //+ bytesToMegabytes(memory));

		// !!!!!!!!!! Example how to build tree using your own numbers !!!!!!!!!!!
		operation.insert(10);
    	operation.insert(6);
    	operation.insert(1);
    	operation.insert(16);
    	operation.Visualisation();

		operation.delete(10);
		operation.Visualisation();
		
		operation.search(1);
		operation.Visualisation();

		operation.search(1000);

		// !!!!!!! "Visualisation()" lines can visualise Tree in console, but it will work correct only with small trees due to boundaries of console. Be careful and comment this lines, if tree is too big !!!!!!!!
		operation.Visualisation();

	}
}
