import java.util.HashMap;
import java.util.Map;

public class ConstructBTreeFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preSize = preorder.length;
        int inSize = inorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inSize;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preSize-1,map,0,inSize-1);
    }

    public TreeNode buildTree(int[] preorder,int pStart,int pEnd, Map<Integer,Integer> map,int iStart,int iEnd){
        if(pStart>pEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[pStart]);
        int pIndex = map.get(preorder[pStart]);
        node.left = buildTree(preorder, pStart + 1, pIndex-iStart+pStart, map, iStart, pIndex - 1);

        node.right = buildTree(preorder, pIndex-iStart+pStart + 1, pEnd, map, pIndex + 1, iEnd);

        return node;
    }
}
