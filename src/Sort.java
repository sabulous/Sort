/*
* Muhammed Sabri Sahin
* Quick Sort
* 27.02.2019
* */
import java.util.Scanner;

public class Sort {
    private int[] arr;
    public final int length;
    public final int lastIndex;

    public Sort() {
        this.arr = readArray();
        this.length = arr.length;
        this.lastIndex = this.length - 1;

        printArray();
    }

    public static void main(String args[]) {
        Sort s = new Sort();
        s.quickSort(0, s.lastIndex);
        s.printArray();
    }

    // prints whether the array is sorted
    void printStatus() {
        System.out.print("Current status of the array: ");
        if(isSorted()) {
            System.out.println("Sorted.");
        } else {
            System.out.println("Not sorted.");
        }
    }

    // checks if the array is sorted
    boolean isSorted() {
        if(arr.length < 2) {
            return true;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    void printArray() {
        System.out.print("Array: ");
        for(Integer i : this.arr) {
            System.out.print(i + ",");
        }
        System.out.print("\b\n");

        printStatus();
    }

    void quickSort(int left, int right) {
        if(left < right) {
            int pivot = partition(0, right); // find the pivot
            quickSort(left, pivot - 1); // sort the first part
            quickSort(pivot + 1, right); // sort the second part
        }
    }

    int partition(int left, int right) {
        int pivot = arr[right]; // pick the last element as pivot
        int pivotIndex = left - 1;
        for(int it = left; it < right; it++) {
            if(arr[it] <= pivot) {
                pivotIndex++;
                arr = swap(arr, pivotIndex, it);
            }
        }
        pivotIndex++;
        swap(arr, pivotIndex, right); // put the pivot element in its correct index
        return pivotIndex;
    }

    // swaps two elements at index i and j in a given array
    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    static int[] readArray() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type the number of elements to read :");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Type the numbers with spaces in between :");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }
}
