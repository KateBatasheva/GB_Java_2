package Lesson2;
/*
1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
MyArrayDataException и вывести результат расчета.*/

public class Lesson2 {
    static int sum = 0;

    public static void main (String[] args) {
        String[][] arr =  {{"1","1","1","1"},
                        {"1","1","1","1"},
                        {"1","1","1","1"},
                        {"1","1","1","1"}};
        try {
            massiv(arr);
             System.out.println("Сумма массива "+sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
             System.out.println("Сумма массива до ошибки " + sum);
        } finally {
             System.out.println("Программа завершила работу");
        }


    }
    private static void massiv(String [][] arr) {
        if (arr.length!=4) {
            throw new MyArraySizeException("Массив содержит неверное количество строк.");
        }
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i].length !=4) {
                throw new MyArraySizeException("Массив содержит неверное количество стобцов в строке "+(i+1)+ ".", i);
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[1].length ; j++) {
                try {
                sum+=Integer.parseInt(arr[i][j]);
            } catch (NumberFormatException e) {
                    throw new MyArrayDataException ("Массив не содержит цифру в ячейке ["+i+"]["+j+"]", i, j);
                }
            }

        }
    }

}
