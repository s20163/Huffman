package Main.java;

public class HuffmanNode {
    public char value;
    public int weight;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(char value, int weight) {
        if (value == ' ') {
            value = '*';
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
                '}';
    }
}
