package Seminar_5;

import java.util.HashMap;

/* 1) Реализуйте структуру телефонной книги с помощью HashMap, 
учитывая, что 1 человек может иметь несколько телефонов. 
 1.1) Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности.*/

public class task_1 {
    public static void main(String[] args) {
        HashMap<Integer, String> phoneBook = new HashMap<Integer, String>();
        phoneBook.put(5126541, "Иванов Иван");
        phoneBook.put(4232541, "Петрова Олеся");
        phoneBook.put(3226542, "Иванов Дмитрий");
        phoneBook.put(5326543, "Иванов Иван");
        phoneBook.put(5132544, "Иванов Дмитрий");
        
        System.out.println(phoneBook);

        HashMap<String, Integer> sortingPeoples = new HashMap<String, Integer>();

        sortedBook(phoneBook, sortingPeoples);

        System.out.println(sortingPeoples);             
    }

    public static void sortedBook(HashMap<Integer, String> Book, HashMap<String, Integer> sortedBook) {
        for (var el: Book.entrySet()){
                String currentValue = el.getValue();
                if (sortedBook.containsKey(currentValue)){
                    Integer count = sortedBook.get(currentValue) + 1;
                    sortedBook.put(currentValue, count);
                }else {
                    sortedBook.put(currentValue, 1);
                }
            }
        
    }
}
