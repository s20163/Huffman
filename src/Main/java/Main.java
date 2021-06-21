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
        System.out.println("ORIGINAL");
        System.out.println(priorityQueue);
        System.out.println("AFTER MIN HEAP");
        priorityQueue = heapMaker.createMinHeap(priorityQueue);
        System.out.println(priorityQueue);

        HuffmanNode root = new HuffmanNode();

        System.out.println("------ ENTERING LOOP ------");
        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.get(0);
            System.out.println("X: " + x);
            priorityQueue = heapMaker.createMinHeap(priorityQueue);
            priorityQueue.remove(0);
            System.out.println("AFTER X REMOVE: " + priorityQueue);

            HuffmanNode y = priorityQueue.get(0);
            System.out.println("Y: " + y);
            priorityQueue = heapMaker.createMinHeap(priorityQueue);
            priorityQueue.remove(0);
            System.out.println("AFTER Y REMOVE: " + priorityQueue);


            HuffmanNode toInsert = new HuffmanNode();

            toInsert.weight = x.weight + y.weight;
            toInsert.value = '&';
            toInsert.left = x;
            toInsert.right = y;

            root = toInsert;
            priorityQueue.add(toInsert);
            System.out.println("AFTER INSERT: " + priorityQueue);
            priorityQueue = heapMaker.createMinHeap(priorityQueue);
            System.out.println("------");
        }
        System.out.println("END: " + root);
        huffmanPrinter.printHuffman(root, "");
    }
}