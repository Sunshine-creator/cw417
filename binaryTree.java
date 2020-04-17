
public class binaryTree {
   public static class Node{
         Node right;
         Node left;
         int key;
       public Node(int key) {      //构造函数，一个内之类
           this.key = key;
       }
   }
//    public binaryTree(int key) {
//       this.key =  key;
//    }
    private Node root = null; //在这里是根节点
    public Node find(int key){  //二叉树的查找
        Node cur =  root;
        while(cur!=null){
            if(key<cur.key){
                cur = cur.left;
            }else if(key>cur.key){
               cur = cur.right;
            }else{
                return cur;
            }
        }
        return null;
    }
    public boolean insert(int key) {
        if (root == null) {
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;  //在这里指向cur的父节点
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                return false;   //找到了一个一样的
            }
        }
        if (parent.key < key) {    //在这里指向znull,cur
            parent.right = new Node(key);
        } else {
            parent.left = new Node(key);
        }
        return  true;
    }
    public boolean delete(int key){
        Node cur =  root;
        Node parent =  null;
        while(cur!=null){
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                removeVal(parent,cur);
                return  true;//找到了一个一样的
            }
        }
        return false;    //key没找到
    }
    private void removeVal(Node parent, Node cur) {
        if(cur.left==null){
            if(cur==root)
            {
                root= cur.right;
            }
            else if(parent.left==cur){
                parent.left =  cur.right;
            }else  {
                parent.right = cur.right;
            }
        }else if{
            if(root==null){
                root = cur.left;
            }else if(parent.left==cur){
                parent.left=cur.left;
            }else {
                parent.right = cur.left;
            }
        }else{
            Node goatParent  =  cur;
            Node sacpeGoat =  cur.right;
            while (sacpeGoat.left!=null){
                goatParent  = sacpeGoat;
                sacpeGoat =  sacpeGoat.left;
            }
            cur.key = sacpeGoat.key;
            if(sacpeGoat==goatParent.left){
                goatParent.left =sacpeGoat.right;
            }else {
                goatParent.right = sacpeGoat.right;
            }
        }
    }
}
