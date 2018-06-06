package com.gavrilov.lesson3;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Applicatiion {
    public static void main(String[] args) {
        //Задание №1
        String[] array = new String[20];
        String symbols = "abc";
        for (int i = 0; i < array.length; i++) { //создание списка случайных слов
            StringBuilder randWord = new StringBuilder();
            int wordLength = 3;
            for (int j = 0; j < wordLength; j++) {
                array[i] = randWord.append
                        (symbols.charAt((int) (Math.random() * symbols.length()))).toString();
            }
        }
        List<String> list = Arrays.asList(array);

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : list) { //добавление в value  повторяющихся в key элементов
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) { //вывод уникальных
            // элементов и количество повторений
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        /*for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }*/

//Задание №2
        Directory directory = new Directory();
        directory.add("Ivanov", "1111");
        directory.add("Ivanov", "1112");
        directory.add("Petrov", "1113");
        System.out.println(directory.get("Ivanov"));//вывод результата поиска
        // номеров однофамильцев
    }
}
