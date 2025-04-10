package logic;

public class Tree {
    Node root;
    public Tree() {root=null;}

    public void add(String element) {
        if(root==null){
            root=new Node(element);
        }
        else{
            searchAdd(root,element);
        }
    }

    private void searchAdd(Node node, String element) {
        if(compare(element,node.getValue())){
            if(node.getLeft()==null)node.setLeft(new Node(element));
            else searchAdd(node.getLeft(),element);
        }else {
            if(node.getRight()==null) node.setRight(new Node(element));
            else searchAdd(node.getRight(),element);
        }
    }
    
    private boolean compare(String value, String value1) {
        value=value.toLowerCase();
        value1=value1.toLowerCase();
        return value.compareTo(value1) < 0;
    }

}
