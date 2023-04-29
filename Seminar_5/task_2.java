package Seminar_5;

/* 2) Реализовать алгоритм пирамидальной сортировки (HeapSort). */

public class task_2 {
    public static void main(String[] args) {
        int[] array = {10, 9, 4, 45, 12, 47, 9, 32, -1};
        System.out.println("Исходный массив:");
        printArr(array);
        System.out.println();
        int[] sortedArr = HeapSort(array);
        System.out.println("Массив отсортированный методом пирамидальной сортировки:");
        printArr(sortedArr);
        
    }

    private static void printArr(int[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    private static int[] HeapSort(int[] array) {
        int length = array.length;
        for(int i = length / 2 - 1; i >= 0; i--){
            heapChange(array, i, length);
        }

        for (int i = length - 1; i >= 0; i--){
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;

            heapChange(array, 0, i);
        }
        return array;
    }

    private static void heapChange(int[] array, int i, int length) {
        int leftEl = i * 2 + 1;
        int rightEl = i * 2 + 2;
        int max = i;
        if (leftEl < length && array[leftEl] > array[max]){
            max = leftEl;
        }
        if (rightEl < length && array[rightEl] > array[max]){
            max = rightEl;
        }
        if (i != max){
            int tmp = array[i];
            array[i] = array[max];
            array[max] = tmp;

            heapChange(array, max, length);
        }
    }
}
