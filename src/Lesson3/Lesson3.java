package Lesson3;

import java.util.*;

public class Lesson3 {
    // 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
    // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    // Посчитать, сколько раз встречается каждое слово.

    // 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    // В этот телефонный справочник с помощью метода add() можно добавлять записи.
    // С помощью метода get() искать номер телефона по фамилии.
    // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    // тогда при запросе такой фамилии должны выводиться все телефоны.


    public static void main (String[] args) {
        //1.
        String[] arrStr = {"Кошка", "Собака", "Енот", "Хорек", "Кошка", "Собака", "Енот", "Курица", "Кошка", "Собака", "Енот"};
        System.out.println(Arrays.toString(arrStr));
        Set<String> arrStrNew = new HashSet<>(Arrays.asList(arrStr));
        System.out.println(arrStrNew);
        Map <String , Integer> animal = new HashMap<>();
        for (int i = 0; i <arrStr.length ; i++) {
            Integer count = animal.getOrDefault(arrStr[i], 0);
            animal.put(arrStr[i], count+1);
        }
         System.out.println(animal);
        

        //2.
        HashMap <String, ArrayList<Integer>> telDirect = new TelDir<String, ArrayList<Integer>>();
        //вариант 1:
         telDirect.put("Петров", new ArrayList<>(Arrays.asList(111,332,656)));

        // вариант 2:
        ArrayList <Integer> ivanov = new ArrayList<>();
        ivanov.add(67567);
        ivanov.add(6767);
        ivanov.add(677);
        telDirect.put("Иванов", ivanov);

        
        System.out.println(telDirect.get("Иванов"));
        System.out.println(telDirect.get("Петров"));
    }
}
