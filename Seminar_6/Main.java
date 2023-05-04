package Seminar_6;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Notebooks> setNotebooks = new HashSet<>(); // создаём множество ноутбуков
        setNotebooks.add(new Notebooks("asus",  8 ,  500 , "windows", "white" ));
        setNotebooks.add(new Notebooks("acer",  2,  300, "mac", "black"));
        setNotebooks.add(new Notebooks("toshiba",   6,   700, "linuks", "black"));
        setNotebooks.add(new Notebooks("hp-pavilion",  6,   500, "windows", "gray"));
        setNotebooks.add(new Notebooks("apple",  8,   500, "mac", "white"));
        setNotebooks.add(new Notebooks("samsung",  6,   700, "windows", "gray"));
        setNotebooks.add(new Notebooks("lenovo",  8,   500, "windows", "silver"));

        System.out.println(setNotebooks.toString()); // выводим имеющееся множество в консоль

        Actions actions = new Actions(setNotebooks);
        actions.start();

    }
}
