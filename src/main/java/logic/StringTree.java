package logic;

import java.util.ArrayList;
import java.util.List;

public class StringTree {

    StringNode root;
    public StringTree() {root=null;}

    public void add(String element) {
        if(root==null){
            root=new StringNode(element);
        }
        else{
            recursionAdd(root,element);
        }
    }

    private void recursionAdd(StringNode node, String element) {
        if (element.equals(node.getValue())) {
            if (compare(element,node.getValue())<0) {
                if(node.getLeft()==null)node.setLeft(new StringNode(element));
                else recursionAdd(node.getLeft(),element);
            }else {
                if(node.getRight()==null) node.setRight(new StringNode(element));
                else recursionAdd(node.getRight(),element);
            }
        }
    }

    public List<String> show() {
        if (root==null) {return null;}
        else {
            List<String> result = new ArrayList<>();
            return recursionShow(root,result);
        }
    }

    private List<String> recursionShow(StringNode node, List<String> res) {
        if (node.getLeft()!=null) res=recursionShow(node.getLeft(),res);
        res.add(node.getValue());
        if (node.getRight()!=null) res=recursionShow(node.getRight(),res);
        return res;
    }

    public String showRoot() {
        if (root != null) return String.valueOf(root.getValue());
        return null;
    }

    public String remove(String element) {
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

    private boolean recursionRemove(StringNode node, String element) {
        if (node.getLeft()!=null && node.getLeft().getValue().equals(element)
                && node.getLeft().getRight()==null && node.getLeft().getLeft()==null){
            node.setLeft(null);
            return true;
        }
        if (node.getRight()!=null && node.getRight().getValue().equals(element)
                && node.getRight().getRight()==null && node.getRight().getLeft()==null){
            node.setRight(null);
            return true;
        }
        if (node.getValue().equals(element)) {
            if(node.getLeft()!=null)node.setValue(searchRightestOfLeft(node));
            else if(node.getRight()!=null)node.setValue(searchLeftestOfRight(node));
            return true;
        }else if (compare(element,node.getValue())>0) {
            if(node.getLeft()!=null) return recursionRemove(node.getLeft(), element);
        }else {
            if(node.getRight()!=null) return recursionRemove(node.getRight(),element);
        }
        return false;
    }

    private String searchLeftestOfRight(StringNode node) {
        if(node.getRight().getLeft()==null){
            String value=node.getRight().getValue();
            node.setRight(node.getRight().getRight());
            return value;
        }else{
            node=node.getRight();
            while(node.getLeft().getLeft()!=null){
                node=node.getLeft();
            }
            String res = node.getLeft().getValue();
            node.setLeft(null);
            return res;
        }
    }

    private String searchRightestOfLeft(StringNode node) {
        if(node.getLeft().getRight()==null){
            String value=node.getLeft().getValue();
            node.setLeft(node.getLeft().getLeft());
            return value;
        }else{
            node=node.getLeft();
            while(node.getRight().getRight()!=null){
                node=node.getRight();
            }
            String res = node.getRight().getValue();
            node.setRight(null);
            return res;
        }
    }

    private int compare(String value, String value1) {
        value=value.toLowerCase();
        value1=value1.toLowerCase();
        return value.compareTo(value1);
    }
}
