package Seminar_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/* Реализуйте очередь с помощью LinkedList со следующими методами:
• enqueue() — помещает элемент в конец очереди,
• dequeue() — возвращает первый элемент из очереди и удаляет его,
• first() — возвращает первый элемент из очереди, не удаляя. */

public class task_2 {
    public static void main(String[] args) {
        Queue<Integer> linkList = new LinkedList<>();
        fillList(linkList);
        System.out.println("Исходный LinkedList --> " + linkList);
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите любое целочисленное число: ");
        int number = scan.nextInt();
        scan.close();
        enqueueList(linkList, number);
        dequeueList(linkList);
        firstElementList(linkList);
    }

    public static void enqueueList(Queue<Integer> inList, int num) {
        inList.add(num);
        System.out.println("Последний элемент очереди успешно добавлен --> " + inList);
    }

    public static void dequeueList(Queue<Integer> inList) {
        System.out.println("Первый элемент очереди --> " + inList.remove());
        System.out.println("Элемент успешно удалён  --> " + inList);
    }

    public static void firstElementList(Queue<Integer> inList) {
        var first = inList.element();
        System.out.println("Первый элемент очереди --> " + first);
        System.out.println("Очередь --> " + inList);
    }

    public static void fillList(Queue<Integer> myLinkList) {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int k = rnd.nextInt(10);
            myLinkList.add(k);
        }

    }
}
