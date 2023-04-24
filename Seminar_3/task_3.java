package Seminar_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;

/*Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка. */

public class task_3 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        fillList(myList);

        System.out.println("Исходный список целых чисел --> " + myList);

        System.out.println("Максимальное значение --> " + Collections.max(myList));
        System.out.println("Минимальное значение --> " + Collections.min(myList));
        System.out.println("Среднее значение --> " + getAverage(myList));

        IntSummaryStatistics stats = myList.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println(stats);
    }

    private static double getAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
    }

    public static void fillList(List<Integer>myList) {
        Random rnd = new Random();
        for (int i = 0; i < 15; i++){
            int k = rnd.nextInt(10);
            myList.add(k);
        }
        
    }
}
