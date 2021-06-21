package Main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();
        CharCounter charCounter = new CharCounter();
        HuffmanPrinter huffmanPrinter = new HuffmanPrinter();
        MinHeap heapMaker = new MinHeap();

        List<HuffmanNode> nodes;
        String toEncode = "";

        try {
            toEncode = fileHandler.readFile("test.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        charCounter.countChars(toEncode);
        nodes = charCounter.returnNodes();
        List<HuffmanNode> priorityQueue = new ArrayList<>(nodes);
        heapMaker.buildMinHeap(priorityQueue);

        HuffmanNode root = new HuffmanNode();

        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.get(0);
            heapMaker.buildMinHeap(priorityQueue);
            priorityQueue.remove(0);

            HuffmanNode y = priorityQueue.get(0);
            heapMaker.buildMinHeap(priorityQueue);
            priorityQueue.remove(0);

            HuffmanNode toInsert = new HuffmanNode();

            toInsert.weight = x.weight + y.weight;
            toInsert.value = '&';

            toInsert.left = x;
            toInsert.right = y;

            root = toInsert;
            priorityQueue.add(toInsert);
        }

            huffmanPrinter.printHuffman(root, "");
    }
}