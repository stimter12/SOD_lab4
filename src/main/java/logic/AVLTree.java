package logic;

public class AVLTree {
    AVLNode root;
    public AVLTree() {root=null;}

    public void add(int element) {
        if(root==null){
            root=new AVLNode(element,1);
        }
        else{
            root=recursionAdd(root,element);
            restoreHeightProperty();
        }
    }

    private AVLNode recursionAdd(AVLNode node, int element) {
        if (element!=node.getValue()) {
            if (element<node.getValue()) {
                if(node.getLeft()==null)node.setLeft(new AVLNode(element,node.getHeight()+1));
                else node.setLeft(recursionAdd(node.getLeft(),element));
            }else {
                if(node.getRight()==null) node.setRight(new AVLNode(element,node.getHeight()+1));
                else node.setRight(recursionAdd(node.getRight(),element));
            }
        }
        return makeTreeBalanced(node);
    }

    public String show() {
        if (root==null) {return null;}
        else {
            String result = "";
            return recursionShow(root,result);
        }
    }

    private String recursionShow(AVLNode node, String res) {
        if (node.getLeft()!=null) res=recursionShow(node.getLeft(),res);
        res+=" ".repeat(node.getHeight()*2)+node.getHeight()+": "+node.getValue()+"\n";
        if (node.getRight()!=null) res=recursionShow(node.getRight(),res);
        return res;
    }

    public String showRoot() {
        if (root != null) return String.valueOf(root.getValue());
        return null;
    }

    public void remove(int element) {
        if(root!=null) root=recursionRemove(root,element);
        if(root!=null) restoreHeightProperty();
    }

    private AVLNode recursionRemove(AVLNode node, int element) {
        if (element<node.getValue()) {
            if(node.getLeft()!=null)node.setLeft(recursionRemove(node.getLeft(),element));
        } else if(element>node.getValue()) {
            if(node.getRight()!=null)node.setRight(recursionRemove(node.getRight(),element));
        }else{
            if(node.getLeft()==null || node.getRight()==null){
                if (node.getLeft() == null) node = node.getRight();
                else node = node.getLeft();
            }else {
                AVLNode successor = leftestOfRight(node.getRight());
                node.setValue(successor.getValue());
                node.setRight(recursionRemove(node.getRight(), successor.getValue()));
            }
        }
        return makeTreeBalanced(node);
    }

    private AVLNode leftestOfRight(AVLNode node) {
        while (node.getLeft()!=null){
            node=node.getLeft();
        }
        return node;
    }

    private void restoreHeightProperty() {
        root.setHeight(1);
        restoreHeightProperty(root);
    }

    private void restoreHeightProperty(AVLNode node) {
        if(node.getLeft()!=null){
            node.getLeft().setHeight(node.getHeight()+1);
            restoreHeightProperty(node.getLeft());
        }
        if(node.getRight()!=null){
            node.getRight().setHeight(node.getHeight()+1);
            restoreHeightProperty(node.getRight());
        }
    }

    public int showHeight() {
        if (root == null) return 0;
        else {
            return showHeightRecursion(root,1,-1);
        }
    }

    private int showHeightRecursion(AVLNode node, int currentHeight,int maxHeight) {
        if (node.getLeft()!=null) {
            int temp=showHeightRecursion(node.getLeft(),currentHeight+1,maxHeight);
            if (temp>maxHeight) maxHeight=temp;
        }
        if (node.getRight()!=null) {
            int temp=showHeightRecursion(node.getRight(),currentHeight+1,maxHeight);
            if (temp>maxHeight) maxHeight=temp;
        }
        if(currentHeight>maxHeight){maxHeight=currentHeight;}
        return maxHeight;
    }
    private AVLNode makeTreeBalanced(AVLNode node){
        if (node==null)return null;
        int left = 0, right = 0;
        if (node.getLeft() != null)
            left = showHeightRecursion(node.getLeft(), 1, -1);
        if (node.getRight() != null)
            right = showHeightRecursion(node.getRight(), 1, -1);
        if (right-left>1) {
            int Rleft=0,Rright=0;
            if (node.getRight().getRight() != null)
                Rright = showHeightRecursion(node.getRight().getRight(), 1, -1);
            if (node.getRight().getLeft() != null)
                Rleft = showHeightRecursion(node.getRight().getLeft(), 1, -1);
            if (Rleft<Rright)node=leftRotate(node);
            else {
                node.setRight(rightRotate(node.getRight()));
                node=leftRotate(node);
            }
        }
        if (right-left<-1){
            int Lleft=0,Lright=0;
            if (node.getLeft().getLeft() != null)
                Lleft = showHeightRecursion(node.getLeft().getLeft(), 1, -1);
            if (node.getLeft().getRight() != null)
                Lright = showHeightRecursion(node.getLeft().getRight(), 1, -1);
            if (Lleft>Lright)node=rightRotate(node);
            else {
                node.setLeft(leftRotate(node.getLeft()));
                node=rightRotate(node);
            }
        }
        return node;
    }

    private AVLNode rightRotate(AVLNode node) {
        AVLNode nodeL=node.getLeft();
        node.setLeft(node.getLeft().getRight());
        nodeL.setRight(node);
        return nodeL;
    }

    private AVLNode leftRotate(AVLNode node) {
        AVLNode nodeR=node.getRight();
        node.setRight(node.getRight().getLeft());
        nodeR.setLeft(node);
        return nodeR;
    }
}