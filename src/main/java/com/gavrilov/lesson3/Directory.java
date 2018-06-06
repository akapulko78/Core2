package com.gavrilov.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Directory {

    private final Map<String, List<String>> directory = new TreeMap<>();

    public void add(String name, String number) {
        if (!directory.containsKey(name)) { //проверяем есть ли такая запись в справочнике
            directory.put(name, new ArrayList<>());//добавляем ключ в случае отсутствия
        }
        directory.get(name).add(number);//добавляем дополнительный номер при наличии
    }

    public List<String> get(String name) {
        return directory.get(name);
    }


}
