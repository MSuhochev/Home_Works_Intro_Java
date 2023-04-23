package Seminar_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;

/*Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка. */

public class task_3 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(3);
        myList.add(1);
        myList.add(2);
        myList.add(5);
        myList.add(6);
        myList.add(4);
        myList.add(9);
        myList.add(7);
        myList.add(10);
        myList.add(8);

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
}
