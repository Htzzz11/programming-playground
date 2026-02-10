package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic binary tree implementation with basic operations and traversals.
 * No ordering is enforced (not a BST).
 */
public class BinaryTree<T> {

    private Node<T> root;
    private int size;

    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public BinaryTree(T rootData) {
        root = new Node<>(rootData);
        size = 1;
    }

    /**
     * Returns the root node of the tree.
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Sets the root node of the tree.
     */
    public void setRoot(Node<T> root) {
        this.root = root;
        // Note: size is not updated automatically
    }

    /**
     * Returns the number of nodes in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Clears all nodes from the tree.
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Performs inorder traversal (left, root, right) and returns the result.
     */
    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, result);
        result.add(node.data);
        inorderHelper(node.right, result);
    }

    /**
     * Performs preorder traversal (root, left, right) and returns the result.
     */
    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        result.add(node.data);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    /**
     * Performs postorder traversal (left, right, root) and returns the result.
     */
    public List<T> postorderTraversal() {
        List<T> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.data);
    }

    /**
     * Calculates and returns the height of the tree.
     */
    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightHelper(node.left);
        int rightHeight = heightHelper(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
