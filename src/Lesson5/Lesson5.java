package Lesson5;

public class Lesson5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        float[] arr2 = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 1;
        }
        System.out.println("Первый метод");
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы " + (System.currentTimeMillis() - a));
        System.out.println("Первый элемент массива " + arr[0]);
        System.out.println("Последний элемент массива " + arr[arr.length-1]);
         System.out.println(" ------ ");

        System.out.println("Второй метод");
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long b = System.currentTimeMillis();
        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);
        Thread first = new Threat(a1,0);
        Thread second = new Threat(a2,h);
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr2, 0, h);
        System.arraycopy(a2, 0, arr2, h, h);
        System.out.println("Время работы " + (System.currentTimeMillis() - b));
         System.out.println("Первый элемент массива " + arr2[0]);
        System.out.println("Последний элемент массива " + arr2[arr2.length-1]);


}
}
