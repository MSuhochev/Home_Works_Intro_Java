package Seminar_3;
/*Реализовать алгоритм сортировки слиянием */

import java.util.Arrays;
import java.util.Random;

public class task_1 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        int[] randomArray = randArray(numArr);
        System.out.println("Исходный массив--> " + Arrays.toString(randomArray));
        int[] sortedArray = sortedArr(randomArray);
        System.out.println("Отсортированный массив--> " + Arrays.toString(sortedArray));
    }

    public static int[] randArray(int[] printArr) {

        int[] randArr = new int[printArr.length];
        Random random = new Random();
        for (int i = 0; i < printArr.length; i++) {
            randArr[i] = random.nextInt(0, 100);
        }
        return randArr;
    }

    private static int[] sortedArr(int[] array) {
        int n = array.length;
        if (n == 1) return array;

        int midlle = n / 2;
        int[] leftArr = new int[midlle];
        int[] rightArr = new int[n - midlle];

        for (int i = 0; i < midlle; i++) {
            leftArr[i] = array[i];
        }
        for (int i = midlle; i < n; i++) {
            rightArr[i - midlle] = array[i];
        }

        sortedArr(leftArr);
        sortedArr(rightArr);
        mergeArr(array, leftArr, rightArr);
        return array;
    }

    private static void mergeArr(int[] sortedArr, int[] leftArr, int[] rightArr) {
        int left = leftArr.length;
        int right = rightArr.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right) {
            if (leftArr[i] < rightArr[j]) {
                sortedArr[idx] = leftArr[i];
                i++;
            } else {
                sortedArr[idx] = rightArr[j];
                j++;
            }
            idx++;
        }
        for (int leftSur = i; leftSur < left; leftSur++)
            sortedArr[idx++] = leftArr[leftSur];
        
        for (int rightSur = j; rightSur < right; rightSur++)
            sortedArr[idx++] = rightArr[rightSur];
    }
}
