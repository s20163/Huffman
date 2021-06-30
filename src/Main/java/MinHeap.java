package Main.java;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
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
//                    lfNode.value = node.value;
//                    lfNode.weight = node.weight;
//                    lfNode.left = node.left;
//                    lfNode.right = node.right;
                    lfNode = node;
                }
            }
            heapedQueue.add(new HuffmanNode(lfNode.value, lfNode.weight, lfNode.left, lfNode.right));
        }
        return heapedQueue;
    }
}