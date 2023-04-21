/* 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */
package Seminar_2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class task_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            File file = new File("datas.json");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);
            pw.println("'name':'Ivanov'");
            pw.println("'country':'Russia'");
            pw.println("'city':'Moscow'");
            pw.println("'age':'null'");
            pw.close();

            StringBuilder res = new StringBuilder("select * from students where ");

            br = new BufferedReader(new FileReader("datas.json"));

            ArrayList<String> line = new ArrayList<>();
            String tmp;
            while ((tmp = br.readLine()) != null) {
                if (!tmp.isEmpty()) {
                    line.add(tmp);
                }
            }

            String n = line.toString();

            String[] formatQuery = n
                .replace('[', '\0')
                .replace(']', '\0')
                .replace('\'', '\0')
                .replace(' ', '\0')
                .split(",");

            for (int i = 0; i < formatQuery.length; i++) {
                if (!formatQuery[i].contains("null")) {
                    res.append(formatQuery[i].split(":")[0])
                            .append(" = ").append('\'')
                            .append(formatQuery[i].split(":")[1])
                            .append('\'').append(" and ");
                }
            }
            res.replace(res.length() - 5, res.length(), "");
            System.out.println("Запрос " + res);

        } catch (

        IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
