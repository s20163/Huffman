package Main.java;

public class HuffmanNode {
    char value;
    int weight;
    HuffmanNode left;
    HuffmanNode right;
    HuffmanNode parent;

    public HuffmanNode(char value, int weight) {
        if (value == ' ') {
            value = '*';
        }
        this.value = value;
        this.weight = weight;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public HuffmanNode getParent() {
        return parent;
    }

    public void setParent(HuffmanNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }
}
