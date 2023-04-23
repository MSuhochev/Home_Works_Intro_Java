package Seminar_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*Пусть дан произвольный список целых чисел, удалить из него чётные числа */

public class task_2 {
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
        Iterator<Integer> col = myList.iterator();
        while (col.hasNext()) {
            if (col.next() % 2 == 0) {
                col.remove();
            }
        }
        System.out.println("Нечётные числа из исходного списка -->" + myList);
    }
    

}
