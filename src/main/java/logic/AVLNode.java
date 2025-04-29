package logic;

class AVLNode {
    private int value;
    private AVLNode left;
    private AVLNode right;
    private int height;
    public AVLNode(int value,int height) {
        this.value=value;
        left=null;
        right=null;
        this.height=height;
    }

    public AVLNode getLeft() {return left;}

    public void setLeft(AVLNode left) {this.left = left;}

    public AVLNode getRight() {return right;}

    public void setRight(AVLNode right) {this.right = right;}

    public int getValue() {return value;}

    public void setValue(int value) {this.value = value;}

    public int getHeight() {return height;}

    public void setHeight(int height) {this.height = height;}
}