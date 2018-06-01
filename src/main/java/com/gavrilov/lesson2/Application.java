package com.gavrilov.lesson2;

public class Application {

    private String[][] array;
    private static int a;

    public Application(String[][] array) {
        this.array = array;
    }

    private static void arrayChange(String array[][]) throws MyArrayDataException {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = "2";
                if (!(array[i][j]).matches("[-+]?\\d+"))
                    try {
                        throw new MyArrayDataException("Введен неверный тип данных " +
                                "в ячейке " + "[" + i + "]:[" + j + "]");
                    } catch (MyArrayDataException e) {
                        e.printStackTrace();
                    }
                a += Integer.parseInt(array[i][j]);
            }
        }
        if (array.length > 4 || array[0].length > 4)
            try {
                throw new MyArraySizeException("Массив неверного размера");
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        System.out.println("сумма:" + a);
    }

    public static void main(String[] args) throws MyArrayDataException {

        String[][] array = new String[4][4];
        arrayChange(array);

    }

    public static class MyArrayDataException extends NumberFormatException {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    private static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

}
