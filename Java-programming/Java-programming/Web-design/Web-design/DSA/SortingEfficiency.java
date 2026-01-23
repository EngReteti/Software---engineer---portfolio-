import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] original = new int[50];
        Random rand = new Random();
        
        // Step 1: Generate 50 random numbers (0 to 100)
        for (int i = 0; i < 50; i++) original[i] = rand.nextInt(101);

        // --- A. BUBBLE SORT ---
        int[] arrB = Arrays.copyOf(original, 50);
        long startB = System.nanoTime();
        bubbleSort(arrB);
        long endB = System.nanoTime();
        System.out.println("Bubble Sort Time:    " + (endB - startB) + " ns");

        // --- B. SELECTION SORT ---
        int[] arrS = Arrays.copyOf(original, 50);
        long startS = System.nanoTime();
        selectionSort(arrS);
        long endS = System.nanoTime();
        System.out.println("Selection Sort Time: " + (endS - startS) + " ns");

        // --- C. MERGE SORT ---
        int[] arrM = Arrays.copyOf(original, 50);
        long startM = System.nanoTime();
        mergeSort(arrM, 0, arrM.length - 1);
        long endM = System.nanoTime();
        System.out.println("Merge Sort Time:     " + (endM - startM) + " ns");
    }

    // BUBBLE SORT logic
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
    }

    // SELECTION SORT logic
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++)
                if (arr[j] < arr[minIdx]) minIdx = j;
            int temp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = temp;
        }
    }

    // MERGE SORT (Divide and Conquer) logic
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { arr[k] = L[i]; i++; }
            else { arr[k] = R[j]; j++; }
            k++;
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
