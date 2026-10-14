
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Current must be null at this point, pop from stack
            current = stack.pop();
            
            // Decrement k, when k reaches 0, we found our kth smallest element
            k--;
            if (k == 0) {
                return current.val;
            }
            
            // We have visited the node and its left subtree. Now it's right subtree's turn.
            current = current.right;
        }
        
        return -1; // Should not reach here if k is valid (1 <= k <= n)
    }
}