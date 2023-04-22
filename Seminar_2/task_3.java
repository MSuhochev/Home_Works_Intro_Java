/* 3. Добавляем логирование к калькулятору */

package Seminar_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.XMLFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            // добавляем логирование
            Logger log = Logger.getLogger(task_3.class.getName());
            log.setLevel(Level.INFO);
            FileHandler fh = new FileHandler("calcLogger.log");
            log.addHandler(fh);
            XMLFormatter xmlf = new XMLFormatter();
            fh.setFormatter(xmlf);
            log.setUseParentHandlers(false);

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
                log.log(Level.INFO, "Enter operation");
                if (operation == 'q')
                    continue;

                System.out.println("Введите первое число:");
                var numberOne = num.nextInt();
                log.log(Level.INFO, "Enter first number");
                System.out.println("Введите второе число:");
                var numberTwo = num.nextInt();
                log.log(Level.INFO, "Enter second number");

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
                log.log(Level.INFO, "Result operation");
                System.out.println();
            }
            num.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
