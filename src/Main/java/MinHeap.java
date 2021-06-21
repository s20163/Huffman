package Main.java;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

//    public void minHeapify(List<HuffmanNode> priorityQueue, int heapSize, int i) {
//        int left = 2 * i;
//        int right = 2 * i + 1;
//        HuffmanNode smallest;
//
//        if (left <= heapSize - 1 && priorityQueue.get(left).weight < priorityQueue.get(i).weight) {
//            smallest = priorityQueue.get(left);
//        } else {
//            smallest = priorityQueue.get(i);
//        }
//
//        if (right <= heapSize - 1 && priorityQueue.get(right).weight < priorityQueue.get(priorityQueue.indexOf(smallest)).weight) {
//            smallest = priorityQueue.get(right);
//        }
//
//        if (smallest.weight != i) {
//            HuffmanNode temp = smallest;
//            smallest = priorityQueue.get(i);
//
//            priorityQueue.get(i).weight = temp.weight;
//            priorityQueue.get(i).value = temp.value;
//            priorityQueue.get(i).right = temp.right;
//            priorityQueue.get(i).left = temp.left;
//
//            minHeapify(priorityQueue, heapSize, smallest.weight);
//        }
//    }
//
//    public void buildMinHeap(List<HuffmanNode> priorityQueue) {
//        int heapSize = priorityQueue.size();
//
//        for (int i = heapSize / 2; i > 1; i--) {
//            minHeapify(priorityQueue, heapSize, i);
//        }
//
//    }

    public void minHeapify(int[] A, int heapSize, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest;

        if (left <= heapSize - 1 && A[left] < A[i]) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= heapSize - 1 && A[right] < A[smallest]) {
            smallest = right;
        }

        if (i != smallest) {
            int temp = A[smallest];
            A[smallest] = A[i];
            A[i] = temp;
            minHeapify(A, heapSize, smallest);
        }
    }

    public void buildMinHeap(int[] A) {
        int heapSize = A.length;

        for (int i = heapSize / 2; i > -1; i--) {
            minHeapify(A, heapSize, i);
        }
    }

    public List<HuffmanNode> createMinHeap(List<HuffmanNode> priorityQueue) {
//        System.out.println("here"+ priorityQueue);
        int[] A = new int[priorityQueue.size()];

        for (int i = 0; i < priorityQueue.size(); i++) {
            A[i] = priorityQueue.get(i).weight;
        }

        buildMinHeap(A);

        List<HuffmanNode> heapedQueue = new ArrayList<>();

        for (int j : A) {
            HuffmanNode lfNode = new HuffmanNode();
            for (HuffmanNode node : priorityQueue) {
                if (node.weight == j) {
                    lfNode = node;
                }
            }
            heapedQueue.add(new HuffmanNode(lfNode.value, j));
        }
        return heapedQueue;
    }
}