package Main.java;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();
        CharCounter charCounter = new CharCounter();
        HuffmanPrinter huffmanPrinter = new HuffmanPrinter();
        MinHeap heapMaker = new MinHeap();
        String toEncode = "";

        try {
            toEncode = fileHandler.readFile("test.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        charCounter.countChars(toEncode);
        List<HuffmanNode> nodes = charCounter.returnNodes();
        System.out.println("ORIGINAL");
        System.out.println(nodes);
        System.out.println("AFTER MIN HEAP");
        heapMaker.buildMinHeap(nodes);
        System.out.println(nodes);

        HuffmanNode root = new HuffmanNode();

        System.out.println("------ ENTERING LOOP ------");
        while (nodes.size() > 1) {
            HuffmanNode x = nodes.get(0);
            System.out.println("X: " + x);
            nodes.remove(0);
            heapMaker.buildMinHeap(nodes);
            System.out.println("AFTER X REMOVE: " + nodes);

            HuffmanNode y = nodes.get(0);
            System.out.println("Y: " + y);
            nodes.remove(0);
            heapMaker.buildMinHeap(nodes);
            System.out.println("AFTER Y REMOVE: " + nodes);

            HuffmanNode toInsert = new HuffmanNode(x.value + y.value, x.weight + y.weight, x, y);
            System.out.println("TO INSERT: " + toInsert);
            root = toInsert;
            nodes.add(toInsert);
            System.out.println("AFTER INSERT: " + nodes);

            heapMaker.buildMinHeap(nodes);
            System.out.println("AFTER MINHEAP: " + nodes);
            System.out.println("------");
        }
        System.out.println("END: " + root);
        huffmanPrinter.printHuffman(root, "");
        fileHandler.createEncodedFile(huffmanPrinter.codingTable, huffmanPrinter.encodeMsg(fileHandler.text));
    }
}