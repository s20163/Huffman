package Main.java;

import java.util.List;

public class MinHeap {

    public void minHeapify(List<HuffmanNode> priorityQueue, int heapSize, int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        HuffmanNode smallest;

        if (left <= heapSize - 1 && priorityQueue.get(left).weight < priorityQueue.get(i).weight) {
            smallest = priorityQueue.get(left);
        } else {
            smallest = priorityQueue.get(i);
        }

        if (right <= heapSize - 1 && priorityQueue.get(right).weight < priorityQueue.get(priorityQueue.indexOf(smallest)).weight) {
            smallest = priorityQueue.get(right);
        }

        if (smallest.weight != i) {
            HuffmanNode temp = smallest;
            smallest = priorityQueue.get(i);

            priorityQueue.get(i).weight = temp.weight;
            priorityQueue.get(i).value = temp.value;
            priorityQueue.get(i).right = temp.right;
            priorityQueue.get(i).left = temp.left;

            minHeapify(priorityQueue, heapSize, smallest.weight);
        }
    }

    public void buildMinHeap(List<HuffmanNode> priorityQueue) {
        int heapSize = priorityQueue.size();

        for (int i = heapSize / 2; i > 1; i--) {
            minHeapify(priorityQueue, heapSize, i);
        }

    }
}