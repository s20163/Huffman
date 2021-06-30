package Main.java;

public class HuffmanPrinter {

    public void printHuffman(HuffmanNode root, String code) {
        if (root.left == null && root.right == null) {
            System.out.println(root.value + ":" + code);

            return;
        }


        printHuffman(root.left, code + "0");
        printHuffman(root.right, code + "1");
    }
}
