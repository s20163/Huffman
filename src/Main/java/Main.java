package Main.java;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();
        CharCounter charCounter = new CharCounter();
        List<HuffmanNode> nodes;
        String toEncode = "";

        try {
            toEncode = fileHandler.readFile("test.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        charCounter.countChars(toEncode);
        nodes = charCounter.returnNodes();

        for (HuffmanNode node : nodes) {
            System.out.println(node);
        }
    }
}