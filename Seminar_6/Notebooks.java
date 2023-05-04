package Seminar_6;

import java.util.ArrayList;
import java.util.List;

public class Notebooks {                     // Поля класса Notebooks
    private String manufacturer;
    private int ram;
    private int hdd;
    private String system;
    private String color;

    public Notebooks(String manufacturer, int ram, int hdd, String system, String color) {
        this.manufacturer = manufacturer;     
        this.ram = ram;
        this.hdd = hdd;                       // Конструктор класса Notebooks
        this.system = system;
        this.color = color;
    }

    @Override                                 // Переопределяем метод вывода в консоль
    public String toString() {
        return String.format("manufacturer: %s, ram: %d, hdd: %d, system: %s, color: %s\n", manufacturer, ram, hdd, system, color);
    }

    public static List<String> propertiesForFilter() {   // свойства фильтрации
        List<String> list = new ArrayList<>();
        list.add("manufacturer");
        list.add("ram");
        list.add("hdd");
        list.add("system");
        list.add("color");
        return list;
    }

    public String getManufacturer(){                  //геттеры и сеттеры полей
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public Integer getRam(){
        return ram;
    }

    public void setRam(Integer ram){
        this.ram = ram;
    }

    public Integer getHdd(){
        return hdd;
    }

    public void setHdd(Integer hdd){
        this.hdd = hdd;
    }

    public String getSystem(){
        return system;
    }

    public void setSystem(String system){
        this.system = system;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
}
