/* * 4. Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет. */

package Seminar_1;

import java.util.Random;
import java.util.Scanner;

public class task_4 {

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Введите значение x от 1 до 9:");
        int x = num.nextInt();
        System.out.println("Введите значение y от 0 до 9:");
        int y = num.nextInt();
        num.close();
        Random random = new Random();
        int x1 = random.nextInt(1, 9);
        int y1 = random.nextInt(0, 9);
        int e = random.nextInt(10, 99);

        System.out.println("Дано уравнение: " + x1 + 'x' + '+' + 'y' + y1 + '=' + e);

        if ((x1 * 10 + x) + (y * 10 + y1) == e) {
            System.out.print("Решение уравнения: " + x1 + x + '+' + y + y1 + '=' + e + " верное!\n");
            return;
        } else {
            System.out.print("Решение уравнения: " + x1 + x + '+' + y + y1 + '=' + e + " - не верное!\n");
        }

        int q1 = 0;
        int w1 = 0;
        int tmp = 0;
        boolean have = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tmp = ((x1 * 10 + i) + (j * 10 + y1));
                if (tmp == e) {
                    q1 = i;
                    w1 = j;
                    System.out.print("Возможное решение:\n");
                    System.out.print("\nВерное равенство: " + x1 + q1 + '+' + w1 + y1 + '=' + e);
                    return;
                }
                else { 
                    have = false;
                }
            }
        }
        if (have == false) {
            System.out.println("\nРешения нет!\n");
        } 
    }
}
