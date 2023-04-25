package Seminar_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/* 1. Пусть дан LinkedList с несколькими элементами. 
Реализуйте метод, который вернёет «перевёрнутый» список. */

public class task_1 {
    public static void main(String[] args) {
        LinkedList<Integer> myLiLi = new LinkedList<Integer>();
        fillList(myLiLi);
        System.out.println("Исходный LinkedList --> " + myLiLi);

        flippedList(myLiLi);

    }

    public static void flippedList(LinkedList<Integer> inLinkedList) {
        Iterator<Integer> iter = inLinkedList.iterator();
        LinkedList<Integer> tmp = new LinkedList<>();
        while (iter.hasNext()) {
            tmp.add(inLinkedList.pollLast());
        }
        System.out.println("Перевёрнутый LinkedList --> " + tmp);
    }

    public static void fillList(LinkedList<Integer> myLinkList) {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int k = rnd.nextInt(10);
            myLinkList.add(k);
        }

    }
}
