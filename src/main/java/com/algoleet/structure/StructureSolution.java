package com.algoleet.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StructureSolution {

    /**
     * #94 Binary Tree Inorder Traversal - https://leetcode.com/problems/binary-tree-inorder-traversal/
     * @param TreeNode root
     * @return List<Integer> list
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return  new ArrayList<Integer>();
        if(root.left == null && root.right == null) return List.of(root.val);
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                list.add(current.val);
                current = current.right; 
            }
        }
        return list;
    }

    /**
     * #94 Binary Tree Inorder Traversal - Inorder Traversal using Recursion
     * @param TreeNode root
     * @return List<Integer> list
     */

    public List<Integer> inorderTraversalRecursion(TreeNode root){
        if(root == null) return  new ArrayList<Integer>();
        if(root.left == null && root.right == null) return List.of(root.val);
        List<Integer> list = new ArrayList<>();
        inorderTraversalRecursion(root, list);
        return list;
    }

    /**
     * a private helper method for the recursive inorder traversal
     * @param TreeNode root
     * @param List<Integer> list
     */
    private void inorderTraversalRecursion(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorderTraversalRecursion(root.left, list);
        list.add(root.val);
        inorderTraversalRecursion(root.right, list);
    }

    /**
     * #144 Binary Tree Preorder Traversal - https://leetcode.com/problems/binary-tree-preorder-traversal/description/
     * @param TreeNode root
     * @return List<Integer> list
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) return List.of(root.val);
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                list.add(current.val);
                if(current.right != null) stack.push(current.right);
                current = current.left;
            }
            else{
                current = stack.pop();
            }
        }
        return list;
    }

    /**
     * #144 Binary Tree Preorder Traversal - https://leetcode.com/problems/binary-tree-preorder-traversal/description/
     * @param TreeNode root
     * @return List<Integer> list
     */
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) return List.of(root.val);
        List<Integer> list = new ArrayList<>();
        preorderTraversalRecursive(root, list);
        return list;
    }

    /**
     * Helper method for recursive preorder traversal
     * @param TreeNode root, List<Integer> list
     */
    private void preorderTraversalRecursive(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        preorderTraversalRecursive(root.left, list);
        preorderTraversalRecursive(root.right, list);
    }

    /*
     * #145 Binary Tree Postorder Traversal - https://leetcode.com/problems/binary-tree-postorder-traversal/
     * @param TreeNode root
     * @return List<Integer> list
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) return List.of(root.val);
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                if(current.right != null) stack.push(current.right);
                current = current.left;
            } else {
                current = stack.pop();
                list.add(current.val);
            } 
        }

        return list; 
    }

    /**
    * #145 Binary Tree Postorder Traversal - Recursive method for postorder traversal
    * @param TreeNode root
    * @return List<Integer> list      
    */
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null &&  root.right == null) return List.of(root.val);
        List<Integer> list = new ArrayList<>();
        postorderTraversalRecursive(root, list);
        return list;
    }

    /**
     * private helper method for recursive binary tree postorder traversal
     * @param TreeNode node
     * @param List<Integer>list
     */
    private void postorderTraversalRecursive(TreeNode node, List<Integer> list){
        if(node == null) return;
        postorderTraversalRecursive(node.left, list);
        postorderTraversalRecursive(node.right, list);
        list.add(node.val);
    }


    /**
     * TreeNode 
     * a nested class required for tree structure
     */
    class TreeNode {
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
}
