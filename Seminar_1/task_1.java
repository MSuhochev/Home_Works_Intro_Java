/* 1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n) */

package Seminar_1;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число: ");
        int n = iScanner.nextInt();
        iScanner.close();
        int a = (n * (n + 1)) / 2;
        System.out.println(n + "-е треугольное число = " + a); // выводим n-ое треугольное число
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        System.out.println("Факториал числа " + n + " (n!) = " + factorial);
    }
}