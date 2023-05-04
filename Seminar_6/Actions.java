package Seminar_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Actions {

    private Set<Notebooks> notebooks = new HashSet<>();
    private List<Criterion> criterionList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void printList() {
        for (Notebooks notebooks : notebooks) {
            if (notebookIsCorrect(notebooks)) {
                System.out.println(notebooks);
            }
        }
    }

    public boolean notebookIsCorrect(Notebooks notebook) {

        for (Criterion criterion : criterionList) {
            Object valueNotebook = null;

            if (criterion.property.equals("manufacturer")) {
                valueNotebook = notebook.getManufacturer();
            } else if (criterion.property.equals("ram")) {
                valueNotebook = notebook.getRam();
            } else if (criterion.property.equals("hdd")) {
                valueNotebook = notebook.getHdd();
            } else if (criterion.property.equals("system")) {
                valueNotebook = notebook.getSystem();
            } else if (criterion.property.equals("color")) {
                valueNotebook = notebook.getColor();
            } else {
                continue;
            }

            if (criterion.value != null && !criterion.value.equals(valueNotebook)) {
                return false;
            }

            if (criterion.maxValue != null
                    && criterion.maxValue < Double.parseDouble(Objects.toString(valueNotebook))) {
                return false;
            }

            if (criterion.minValue != null
                    && criterion.minValue > Double.parseDouble(Objects.toString(valueNotebook))) {
                return false;
            }
        }

        return true;
    }

    public Actions(Set<Notebooks> notebooks) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
    }

    public Actions(Set<Notebooks> notebooks, List<Criterion> criterionList) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
        this.criterionList = criterionList;
    }

    public int getCriteria() {
        String text = "Введите цифру, соответствующую необходимому критерию: ";

        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++) {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);

        int value = scanner.nextInt();

        return value;
    }

    public String getPropertyDescription(String property) {

        Map<String, String> descriptionsProperties = descriptionsProperties();

        return descriptionsProperties.get(property);

    }

    public Map<String, String> descriptionsProperties() {
        Map<String, String> map = new HashMap<>();

        map.put("manufacturer", "Производитель");
        map.put("ram", "Объем оперативной памяти");
        map.put("hdd", "Объём жесткого диска");
        map.put("system", "Операционная система");
        map.put("color", "Цвет");

        return map;

    }

    public List<String> propertiesForFilter() {
        List<String> list = new ArrayList<>();
        list.add("manufacturer");
        list.add("ram");
        list.add("hdd");
        list.add("system");
        list.add("color");

        return list;
    }

    public String getOperations() {

        String menu = "Меню: \n " +
                "1 - Вывести список \n " +
                "2 - Добавить критерий \n " +
                "3 - Удалить критерий \n " +
                "q - Выход";

        System.out.println(menu);

        String answer = scanner.next();
        if (!answer.equals("1")
                && !answer.equals("2")
                && !answer.equals("3")
                && !answer.equals("q")) {
            System.out.println("Ошибка при выборе критерия, введите \"1\" \"2\" \"3\"или \"q\"");
        }

        return answer;
    }

    public Set<String> numericSelection() {
        Set<String> set = new HashSet<>();
        set.add("ram");
        set.add("hdd");

        return set;
    }

    public void start() {

        boolean flag = true;
        while (flag) {

            String operation = getOperations();
            if (operation.equals("q")) {
                flag = false;
                scanner.close();
                continue;
            } else if (operation.equals("1")) {
                printList();
            } else if (operation.equals("2")) {

                int criterion = getCriteria();
                List<String> properties = propertiesForFilter();
                if (criterion - 1 < 0 || criterion - 1 > properties.size() - 1) {
                    System.out.println("Введено некорректное значение");
                    continue;
                }
                String property = properties.get(criterion - 1);
                Criterion criterionObject = null;
                try {
                    if (numericSelection().contains(property)) {
                        criterionObject = Criterion.startGetting(scanner, property, true);
                    } else {
                        criterionObject = Criterion.startGetting(scanner, property, false);
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка при выборе критерия");
                    continue;
                }
                if (criterionObject != null) {
                    System.out.println("Критерий успешно добавлен, выберите действие 2 для отображения результата: ");
                    criterionList.add(criterionObject);
                }
            } else if (operation.equals("3")) {
                criterionList.clear();
            }
        }
    }
}

class Criterion {

    Object value;
    Double minValue;
    Double maxValue;
    boolean isQuantity;
    String property;

    public Criterion(String property, boolean isQuantity, Object value, Double minValue, Double maxValue) {
        this.property = property;
        this.isQuantity = isQuantity;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static Criterion startGetting(Scanner scanner, String property, boolean isQuantity) {

        if (isQuantity) {

            String quest = "Введите число соответствующее критерию поиска: " +
                    "\n 1. Значение" +
                    "\n 2. Меньше" +
                    "\n 3. Больше" +
                    "\n 4. Интервал";
            System.out.println(quest);

            String text = scanner.next();

            Criterion criterion = null;

            if (text.equals("1")) {
                System.out.println("Введите значение поиска: ");
                int getValue = scanner.nextInt();
                criterion = new Criterion(property, isQuantity, getValue, null, null);
            } else if (text.equals("2")) {
                System.out.println("Введите максимальное предельное значение: ");
                double getValue = scanner.nextDouble();
                criterion = new Criterion(property, isQuantity, null, null, getValue);
            } else if (text.equals("3")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getValue = scanner.nextDouble();
                criterion = new Criterion(property, isQuantity, null, getValue, null);
            } else if (text.equals("4")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getMin = scanner.nextDouble();
                System.out.println("Введите максимальное предельное значение: ");
                double getMax = scanner.nextDouble();
                criterion = new Criterion(property, isQuantity, null, getMin, getMax);
            }

            return criterion;
        }

        System.out.println("Введите значение поиска: ");
        String getValue = scanner.next().toLowerCase();
        return new Criterion(property, isQuantity, getValue, null, null);
    }

}
