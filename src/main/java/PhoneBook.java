import com.sun.org.apache.xpath.internal.objects.XNumber;
import sun.plugin.javascript.navig.Link;

import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> phoneBook;
    private List<String> listNumber;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String number) {
        if (phoneBook.containsKey(name)) {
            listNumber = phoneBook.get(name);
            if (!(listNumber.contains(number))) {
                listNumber.add(number);
                phoneBook.put(name, listNumber);
            }
        } else {
            listNumber = new ArrayList<>();
            listNumber.add(number);
            phoneBook.put(name, listNumber);
        }
    }

    public void get(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println("Найдены номера телефонов по имени \"" + name + "\": " + phoneBook.get(name));
        } else {
            System.out.println("Номера телефонов не найдены.");
        }

    }

}
