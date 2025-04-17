package logic;

class StringNode {
    private String value;
    private StringNode left;
    private StringNode right;
    public StringNode(String value) {
        this.value=value;
        left=null;
        right=null;
    }

    public StringNode getLeft() {return left;}

    public void setLeft(StringNode left) {this.left = left;}

    public StringNode getRight() {return right;}

    public void setRight(StringNode right) {this.right = right;}

    public String getValue() {return value;}

    public void setValue(String value) {this.value = value;}

}