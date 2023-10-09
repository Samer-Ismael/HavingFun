package org.example;

public class BinaryTree {


    public Node createNode (int value){
        Node node = new Node();
        node.data = value;
        node.left = null;
        node.right = null;
        return node;
    }
    public BinaryTree (){
        BinaryTree tree = new BinaryTree();

        Node root = tree.createNode(2);
        root.left = tree.createNode(7);
        root.right = tree.createNode(5);
        root.left.left = tree.createNode(2);
        root.left.right = tree.createNode(6);
        root.left.right.left = tree.createNode(5);
        root.left.right.left = tree.createNode(11);
        root.right.right = tree.createNode(9);
        root.right.right.left = tree.createNode(4);
    }
}
