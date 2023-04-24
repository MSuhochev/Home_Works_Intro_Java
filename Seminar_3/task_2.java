package Seminar_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*Пусть дан произвольный список целых чисел, удалить из него чётные числа */

public class task_2 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        fillList(myList);

        System.out.println("Исходный список целых чисел --> " + myList);
        Iterator<Integer> col = myList.iterator();
        while (col.hasNext()) {
            if (col.next() % 2 == 0) {
                col.remove();
            }
        }
        System.out.println("Нечётные числа из исходного списка -->" + myList);
    }
    
    public static void fillList(List<Integer>myList) {
        Random rnd = new Random();
        for (int i = 0; i < 15; i++){
            int k = rnd.nextInt(10);
            myList.add(k);
        }
        
    }
    

}
