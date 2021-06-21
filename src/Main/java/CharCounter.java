package Main.java;

import java.util.ArrayList;
import java.util.List;

public class CharCounter {
    static final int MAX_CHAR = 256;
    private final ArrayList<HuffmanNode> nodes = new ArrayList<>();

    public void countChars(String text) {
        int[] count = new int[MAX_CHAR];
        char[] ch = new char[text.length()];
        int n = text.length();

        for (int i = 0; i < n; i++) {
            count[text.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            ch[i] = text.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (text.charAt(i) == ch[j]) {
                    find++;
                }
            }

            if (find == 1) {
                nodes.add(new HuffmanNode(text.charAt(i), count[text.charAt(i)]));
            }
        }
    }

    public List<HuffmanNode> returnNodes() {
        return nodes;
    }
}
