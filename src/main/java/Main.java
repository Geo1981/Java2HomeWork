public class Main {
    public static void main(String[] args) {
        System.out.println("Начали проверу исключений.");

        String[][] arrayTest = {{"Sam", "Smith"}, {"Robert", "Delgro"}};//, {"James", "Gosling"}};
        System.out.println("Создали массив для проверки MyArraySizeException. arrayTest, размер: [" + arrayTest.length + "][" + arrayTest[0].length + "]");
        try {
            arrayTestMyExep(arrayTest);
        } catch (MyArraySizeException e) {
            System.out.println("Перехваченное исключение! " + e);
        } catch (MyArrayDataException e) {
            System.out.println("Перехваченное исключение. " + e);
        }
        System.out.println("");

        String[][] arrayTest1 = {{"5", "2", "1", "2"}, {"1", "2", "1", "$"}, {"1", "2", "1", "2"}, {"1", "2", "1", "2"}};//, {"James", "Gosling"}};
        System.out.println("Создали массив для проверки MyArrayDataException. arrayTest1, размер: [" + arrayTest1.length + "][" + arrayTest1[0].length + "]");
        try {
            arrayTestMyExep(arrayTest1);
        } catch (MyArraySizeException e) {
            System.out.println("Перехваченное исключение! " + e);
        } catch (MyArrayDataException e) {
            System.out.println("Перехваченное исключение. " + e);
        }
        System.out.println("");

        String[][] arrayTest2 = {{"1", "2", "1", "2"}, {"1", "2", "1", "2"}, {"1", "2", "1", "2"}, {"1", "2", "1", "2"}};//, {"James", "Gosling"}};
        System.out.println("Создали массив для расчета суммы ячеек. arrayTest2, размер: [" + arrayTest2.length + "][" + arrayTest2[0].length + "]");
        try {
            arrayTestMyExep(arrayTest2);
        } catch (MyArraySizeException e) {
            System.out.println("Перехваченное исключение! " + e);
        } catch (MyArrayDataException e) {
            System.out.println("Перехваченное исключение. " + e);
        }

        System.out.println("Закончили проверки.");
    }

    public static void arrayTestMyExep(String[][] arrayTest) throws MyArraySizeException, MyArrayDataException {
        if ((arrayTest[0].length & arrayTest.length) != 4) {
            throw new MyArraySizeException("Ошибка! Массив не размера 4Х4." + arrayTest[0][0]);
        }

        int arrayTestSum = 0;
        int indexI = 0;
        int indexJ = 0;
        int[][] arrayTestInt = new int[arrayTest.length][arrayTest.length];
        for (int i = 0; i < arrayTest.length; i++) {
            indexI = i;
            for (int j = 0; j < arrayTest.length; j++) {
                indexJ = j;
                try {
                    arrayTestInt[i][j] = Integer.parseInt(arrayTest[i][j]);
                    arrayTestSum = arrayTestSum + arrayTestInt[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка! Не корректный символ \"" + arrayTest[i][j] + "\" в ячейке [" + indexI + "][" + indexJ + "].");
                }
            }
        }
        if (arrayTestSum > 0) {
            System.out.println("Сумма ячеек масссива: " + arrayTestSum);
        }
    }
}
