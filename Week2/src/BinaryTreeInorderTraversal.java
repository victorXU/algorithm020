import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root,result);
        return result;
    }

    public void inOrder(TreeNode node,List<Integer> result){
        if (node==null){
            return;
        }
        inOrder(node.left,result);
        result.add(node.val);
        inOrder(node.right,result);
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root!=null||!deque.isEmpty()){
            while (root!=null){
                deque.push(root);
                root=root.left;
            }
            root = deque.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
