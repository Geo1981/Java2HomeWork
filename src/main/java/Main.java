import java.util.*;

public class Main {
    public static void main(String args[]) {
        System.out.println("Задание 1.");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Москва", "Питер", "Москва", "Вологда", "Москва", "Питер", "Кострома", "Калиниград", "Горький", "Владивосток", "Курск", "Горький"));
        System.out.println("Начальные данные. Размер " + list.size() + ", содержит:" + list);
        Iterator<String> iterator = list.iterator();
        Map<String, Integer> uniqueValues = new HashMap<>();

        while (iterator.hasNext()) {
            String str = iterator.next();
            if (uniqueValues.containsKey(str)) {
                int count = uniqueValues.get(str);
                uniqueValues.put(str, count + 1);
            } else {
                uniqueValues.put(str, 1);
            }
        }
        System.out.println("Уникальные значения: " + uniqueValues);
        System.out.println("");


        System.out.println("Задание 2.");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иван", "1");
        phoneBook.add("Петр", "22");
        phoneBook.add("Сидор", "22");
        phoneBook.add("Сидор", "4444");
        phoneBook.add("Сидор", "333");
        phoneBook.add("Сидор", "333");
        phoneBook.get("Сидор");
    }
}
