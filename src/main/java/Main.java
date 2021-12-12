import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1.");
        Integer[] array = {1, 2, 20, 4, 10};
        System.out.print("Дан массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        int number = 2;
        System.out.println("Индекс числа " + number + " в массиве = " +
                search(array, number, (list) -> {
                    for (int i = 0; i < list.length; i++) {
                        if (list[i] == number) {
                            return i;
                        }
                    }
                    return -1;
                }));
        System.out.println();

        System.out.println("Задание 2.");
        String line = "А роза упала на лапу азора";
        System.out.println("Дана строка: " + line);
        System.out.println("Строка наборот: " +
                reverse(line, (str) -> new StringBuffer(str).reverse().toString()));
        System.out.println();

        System.out.println("Задание 3.");
        System.out.print("Дан массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        System.out.println("Максимальное значение: " +
                maximum(array, (list) -> {
                    Arrays.sort(list);
                    int Index = list.length;
                    return list[Index - 1];
                }));
        System.out.println();

        System.out.println("Задание 4.");
        List<Integer> arraylist = Arrays.asList(1, 2, 20, 4, 10);
        System.out.println("Дан список " + arraylist);
        System.out.println("Среднее значение чисел массива: " +
                average(arraylist, (list) -> {
                    double summa = 0;
                    for (int i = 0; i < list.size(); i++) {
                        summa += list.get(i);
                    }
                    return summa / list.size();
                }));
        System.out.println();

        System.out.println("Задание 5.");
        List<String> arraylistWords = Arrays.asList("АаAа", "ааа", "амар", "Ара", "Варан", "ара");
        System.out.println("Дан список строк: " + arraylistWords);
        System.out.println("Выбраны строки из 3-х букв, начинающиеся с \"а\" в нижнем регистре: " +
                searchWords(arraylistWords, (list) -> {
                    List<String> arrayListTemp = new ArrayList<>();
                    Iterator<String> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        String str = iterator.next();
                        if (str.length() == 3 && str.startsWith("а")) {
                            arrayListTemp.add(str);
                        }
                    }
                    return arrayListTemp;
                }));
    }

    public static Integer search(Integer[] list, Integer number, Function<Integer[], Integer> function) {
        return function.apply(list);
    }

    public static String reverse(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static Integer maximum(Integer[] list, Function<Integer[], Integer> function) {
        return function.apply(list);
    }

    public static Double average(List<Integer> list, Function<List<Integer>, Double> function) {
        return function.apply(list);

    }

    public static List<String> searchWords(List<String> list, Function<List<String>, List<String>> function) {
        return function.apply(list);
    }
}
