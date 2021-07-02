package Main.java;

import java.util.Collections;
import java.util.List;

public class MinHeap {

    private void minHeapify(List<HuffmanNode> nodes, int heapSize, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest;

        if (left <= heapSize - 1 && nodes.get(left).weight <= nodes.get(i).weight) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= heapSize - 1 && nodes.get(right).weight < nodes.get(smallest).weight) {
            smallest = right;
        }

        if (i != smallest) {
            Collections.swap(nodes, smallest, i);
            minHeapify(nodes, heapSize, smallest);
        }
    }

    public void buildMinHeap(List<HuffmanNode> nodes) {
        int heapSize = nodes.size();
        for (int i = heapSize / 2; i > -1; i--) {
            minHeapify(nodes, heapSize, i);
        }
    }
}