package com.gl.javafsd.bst.node;
import java .io.*;

    class Node {
	int val;
	 Node left, right;

	
	Node(int item){ 
		val=item;
		 left =right=null;
	}
}
   public class BinarySearchTree
   {
	   public static Node node;
	   static Node prevNode=null;
	   static Node headNode=null;
	   static void flattenBSTToSkewed(Node root, int order) {
		  
		   if(root==null)
		   {
			   return;
		   }
		   if(order>0)
		   {
			   flattenBSTToSkewed(root.right, order);
		   }
		   else
		   {
			   flattenBSTToSkewed(root.left, order);
		   }
		   Node rightNode=root.right;
		   Node leftNode=root.left;
		   
		   if(headNode==null)   
		   {
			   headNode=root;
               root.left=null;
			   prevNode=root;
		   }

		   else
		   {
	           prevNode.right=root;
			   root.left=null;
               prevNode=root;
		   }
		   if (order>0)
		   {
			   flattenBSTToSkewed(leftNode, order);
		   }
		   else
		   {
			   flattenBSTToSkewed(rightNode,order);
			   
		   }
		   }

	    static void traverseRightSkewed(Node root)
		   {
			   if (root==null)
			   {
				   return;
			   }
			   System.out.print(root.val+" ");
			   traverseRightSkewed(root.right);
		   }
		   
		   
   
   
   public static void main (String[]args)
   {
	   BinarySearchTree tree= new BinarySearchTree();
	   tree.node= new Node(50);
	   tree.node.left= new Node(30);
	   tree.node.right= new Node (60);
	   tree.node.left.left=new Node(10);
	   tree.node.right.left=new Node(55);
	   
	   int order=0;
	   flattenBSTToSkewed(node,order);
	   traverseRightSkewed(headNode);

   }
}
