/* 2. Вывести все простые числа от 1 до 1000 */

package Seminar_1;

import java.util.ArrayList;

public class task_2 {
    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = new ArrayList<Integer>(); // создаём пустой список для накопления простых чисел
        for (int minValue = 2; minValue <= 1001; minValue++) {
            boolean primeNum = true;                              // флаг для простого числа 
            for (int j = 2; j <= Math.sqrt(minValue); j++) {      
                if ((minValue % j) == 0) {                        // Если есть делитель - флаг = false
                    primeNum = false;
                    break;
                }
            }
            if (primeNum) {
                myArrayList.add(minValue);            // если делителей нет, флаг True, добавляем элемент в список
            }
        }
        System.out.print(myArrayList);               //вывод списка в консоль
    }
}
