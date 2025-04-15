package logic;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root;
    public Tree() {root=null;}

    public void add(int element) {
        if(root==null){
            root=new Node(element);
        }
        else{
            recursionAdd(root,element);
        }
    }

    private void recursionAdd(Node node, int element) {
        if (element!=node.getValue()) {
            if (element<node.getValue()) {
                if(node.getLeft()==null)node.setLeft(new Node(element));
                else recursionAdd(node.getLeft(),element);
            }else {
                if(node.getRight()==null) node.setRight(new Node(element));
                else recursionAdd(node.getRight(),element);
            }
        }
    }
    
    private int compare(String value, String value1) {
        value=value.toLowerCase();
        value1=value1.toLowerCase();
        return value.compareTo(value1);
    }

    public List<Integer> show() {
        if (root==null) {return null;}
        else {
            List<Integer> result = new ArrayList<>();
            return recursionShow(root,result);
        }
    }

    private List<Integer> recursionShow(Node node, List<Integer> res) {
        if (node.getLeft()!=null) recursionShow(node.getLeft(),res);
        res.add(node.getValue());
        if (node.getRight()!=null) res=recursionShow(node.getRight(),res);
        return res;
    }

    public String showRoot() {
        if (root != null) return String.valueOf(root.getValue());
        return null;
    }

    public String remove(int element) {
        if(root==null){
            return "tree null";
        }
        else{
            if(recursionRemove(root,element)){
                return "element successfully removed";
            }else {
                return "element not found";
            }
        }
    }

    private boolean recursionRemove(Node node, int element) {
        if (node.getLeft()!=null && node.getLeft().getValue()==element
                && node.getLeft().getRight()==null&&node.getLeft().getLeft()==null){
            node.setLeft(null);
            return true;
        }
        if (node.getRight()!=null && node.getRight().getValue()==element
                && node.getRight().getRight()==null && node.getRight().getLeft()==null){
            node.setRight(null);
            return true;
        }
        if (element==node.getValue()) {
            if(node.getLeft()!=null)node.setValue(searchRightestOfLeft(node));
            else if(node.getRight()!=null)node.setValue(searchLeftestOfRight(node));
            return true;
        }else if (element<node.getValue()) {
                if(node.getLeft()!=null) recursionRemove(node.getLeft(),element);
            }else {
                if(node.getRight()!=null) recursionRemove(node.getRight(),element);
            }
        return false;
    }

    private int searchLeftestOfRight(Node node) {
        if(node.getRight().getLeft()==null){
            int value=node.getRight().getValue();
            node.setRight(node.getRight().getRight());
            return value;
        }else{
            node=node.getRight();
            while(node.getLeft()!=null){
                node=node.getLeft();
            }
            return node.getValue();
        }
    }

    private int searchRightestOfLeft(Node node) {
        if(node.getLeft().getRight()==null){
            int value=node.getLeft().getValue();
            node.setLeft(node.getLeft().getLeft());
            return value;
        }else{
            node=node.getLeft();
            while(node.getRight()!=null){
                node=node.getRight();
            }
            return node.getValue();
        }
    }
}
