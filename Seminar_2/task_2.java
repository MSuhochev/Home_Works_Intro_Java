package Seminar_2;
/* 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
      результат после каждой итерации запишите в лог-файл.*/

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class task_2 {
    public static void main(String[] args) {
        try{
        //добавляем логирование
        Logger log = Logger.getLogger(task_2.class.getName());
        log.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("logger.log");
        log.addHandler(fh);
        XMLFormatter xmlf = new XMLFormatter();
        fh.setFormatter(xmlf);
        log.setUseParentHandlers(false);    

        // создаём: 1 - новый массив(заполненный случайными числами), 2 - сортируем полученный массив 
        int[] numbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers[i] = random.nextInt(0, 100);
            log.log(Level.INFO, "Creating new random array");
        }
        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    isSorted = false;
                    buf = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = buf;
                    log.log(Level.INFO, "Sorting Array");
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(numbers));
    } catch(IOException ex) {
        ex.printStackTrace();
    }

    }
}
