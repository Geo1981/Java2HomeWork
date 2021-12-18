import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        float[] arr;
        long startTime, endTime;
        System.out.println("Запуск firstMethod.");
        System.out.println("    Создаем массив заполненый единицами.");
        arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        System.out.println("        Запустили отсчет времени цикла.");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        endTime = System.currentTimeMillis();
        System.out.println("        Закончили отсчет. Время выполнения цикла: " + String.valueOf(endTime - startTime) + " мс.");
        System.out.println();
    }

    public static void secondMethod() {
        float[] arr, arrLeft, arrRight;
        long startTime, endTime;
        System.out.println("Запуск secondMethod.");
        System.out.println("    Создаем массив заполненый единицами.");
        arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        arrLeft = new float[HALF];
        arrRight = new float[HALF];
        startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arrLeft, 0, HALF);
        System.arraycopy(arr, HALF, arrRight, 0, HALF);
        endTime = System.currentTimeMillis();
        System.out.println("    Время выполнения разделения массива: " + String.valueOf(endTime - startTime) + " мс.");
        System.out.println("        Создаем потоки.");
        Thread threadLeft = new Thread(() -> {
            calculationArray(arrLeft, "threadLeft");
        });
        Thread threadRight = new Thread(() -> {
            calculationArray(arrRight, "threadRight");
        });
        try {
            threadLeft.start();
            threadRight.start();
            threadLeft.join();
            threadRight.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("    Начали склейку массивов.");
        startTime = System.currentTimeMillis();
        System.arraycopy(arrLeft, 0, arr, 0, HALF);
        System.arraycopy(arrRight, 0, arr, HALF, HALF);
        endTime = System.currentTimeMillis();
        System.out.println("    Время выполнения склейки массива: " + String.valueOf(endTime - startTime) + " мс.");
        /*System.out.println(Arrays.toString(arrLeft));
        System.out.println(Arrays.toString(arrRight));
        System.out.println(Arrays.toString(arr));*/
    }

    public static void calculationArray(float[] array, String threadName) {
        long startTime, endTime;
        System.out.println("            Открыли поток " + threadName);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        endTime = System.currentTimeMillis();
        System.out.println("            Закрыли поток " + threadName + ", время выполнения цикла: " + String.valueOf(endTime - startTime) + " мс.");
    }
}
