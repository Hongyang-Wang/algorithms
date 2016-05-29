package algorithms.tree;

/* leetcode #297 */
public class TreeSerialization {
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val + ",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] index = {0};
        return preorder(tokens, index);
    }
    
    private TreeNode preorder(String[] tokens, int[] index) {
        if (index[0] >= tokens.length)
            return null;
        String val = tokens[index[0]++];
        if (val.equals("#"))  // use equals() for string comparison
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = preorder(tokens, index);
        node.right = preorder(tokens, index);
        return node;
    }	
	
}
