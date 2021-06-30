package Main.java;

public class HuffmanNode {
    public String value;
    public int weight;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(String value, int weight, HuffmanNode left, HuffmanNode right) {
        this.value = value;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public HuffmanNode(String value, int weight) {
        if (value.equals(" ")) {
            value = "[]";
        }
        this.value = value;
        this.weight = weight;
    }

    public HuffmanNode() {}

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
