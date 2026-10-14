class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // Traverse left subtree
        traverse(node.left, result);
        // Visit node
        result.add(node.val);
        // Traverse right subtree
        traverse(node.right, result);
    }
}