package Main.java;

import java.util.ArrayList;
import java.util.List;

public class HuffmanPrinter {
    public String codingTable = "";
    public String codedMsg = "";

    public void printHuffman(HuffmanNode root, String code) {
        if (root.left == null && root.right == null) {
            System.out.println(root.value + ":" + code + ":");
            codingTable += root.value + ":" + code + ":";

            return;
        }

        printHuffman(root.left, code + "0");
        printHuffman(root.right, code + "1");

    }

    public void encodeMsg(String msg) {
        String[] explodedCodeValues = codingTable.split(":");
        List<HuffmanNode> codedNodes = new ArrayList<>();
        for (int i = 0; i < explodedCodeValues.length; i += 2) {
            codedNodes.add(new HuffmanNode(explodedCodeValues[i], Integer.parseInt(explodedCodeValues[i + 1])));
        }

        for (char ch : msg.toCharArray()) {
            for (int i = 0; i < codedNodes.size(); i++) {
                if (codedNodes.get(i).value.equals(String.valueOf(ch))) {
                    codedMsg += codedNodes.get(i).weight;
                }
                if (ch == ' ' && codedNodes.get(i).value.equals("[]")) {
                    codedMsg += codedNodes.get(i).weight;
                }
            }
        }
    }
}
