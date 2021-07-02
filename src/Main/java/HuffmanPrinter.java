package Main.java;

public class HuffmanPrinter {
    public String codeTable = "";
    public String codedMsg = "";

    public void printHuffman(HuffmanNode root, String code) {
        if (root.left == null && root.right == null) {
            System.out.println(root.value + ":" + code);
            codeTable += root.value + ":" + code;

            return;
        }

        printHuffman(root.left, code + "0");
        printHuffman(root.right, code + "1");

    }
}
