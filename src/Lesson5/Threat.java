package Lesson5;

public class Threat extends Thread {
    public float [] arr;
    public int constanta;
    public Threat(float [] arr, int constanta) {
        this.arr = arr;
        this.constanta= constanta;

    }

    @Override
    public void run() {
    arrM(arr, constanta);
    }

    public float [] arrM (float [] arr, int constanta){
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (constanta+i) / 5) * Math.cos(0.2f + (constanta+i) / 5) * Math.cos(0.4f + (constanta+i) / 2));
        } return arr;
    }
}
