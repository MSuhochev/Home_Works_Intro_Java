/* 3. Реализовать простой калькулятор */

package Seminar_1;

import java.io.IOException;
import java.util.Scanner;

public class task_3 {
    Scanner iScanner = new Scanner(System.in);

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Calculator();
    }

    public static void Calculator() throws IOException {
        Scanner num = new Scanner(System.in);
        char operation = ' ';
        while (operation != 'q') {
            String multipleLines = "Простой калькулятор, меню:" +
                    "\n(*)-умножение," +
                    "\n(/)-деление," +
                    "\n(+)-сложение," +
                    "\n(-)-вычитание," +
                    "\n(%)-остаток от деления," +
                    "\n(q)-выход";
            System.out.println(multipleLines);

            System.out.println("Введите операцию:");
            var code = System.in.read();
            operation = (char) code;
            if (operation == 'q') continue;

            System.out.println("Введите первое число:");
            var numberOne = num.nextInt();
            System.out.println("Введите второе число:");
            var numberTwo = num.nextInt();

            var result = 0;
            switch (operation) {
                case '*':
                    result = numberOne * numberTwo;
                    break;
                case '/':
                    result = numberOne / numberTwo;
                    break;
                case '+':
                    result = numberOne + numberTwo;
                    break;
                case '-':
                    result = numberOne - numberTwo;
                    break;
                case '%':
                    result = numberOne % numberTwo;
                    break;
                default:
                    System.out.print("Error! Enter correct operator");
                    continue;
            }
            System.out.println("Результат операции: " + result);
            System.out.println();
        }
        num.close();
    }

}
