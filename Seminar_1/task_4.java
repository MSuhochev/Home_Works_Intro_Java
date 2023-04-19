/* * 4. Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет. */

package Seminar_1;

import java.util.Random;

public class task_4 {
    static int num_mirror(int a) {
        int f = 0;
        while (a > 10) {
            f += a % 10;
            f *= 10;
            a /= 10;
        }
        f += a;
        return f;
    }

    public static void main(String[] args) {

        Random random = new Random();
        int x = random.nextInt(10, 99);
        int y = random.nextInt(10, 99);
        int e = x + y;
        int q = x / 10;
        int w = num_mirror(y) / 10;
        System.out.printf("Дано уравнение:   %dx + x%d = %d\n", q, w, e);
        int q1 = 0;
        int w1 = 0;
        int temp = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp = ((q * 10) + i) + (w + (10 * j));
                if (temp == e) {
                    q1 = ((q * 10) + i);
                    w1 = (w + (10 * j));

                }
            }
        }
        if (q1 != 0 & w1 != 0) {
            System.out.printf("\nВерное равенство: %d + %d = %d\n", q1, w1, q1 + w1);
            System.out.printf("\tПРОВЕРКА: %d + %d = %d\n\n", x, y, e);

        } else {
            System.out.println("\nРешения нет!\n");
        }
    }
}
