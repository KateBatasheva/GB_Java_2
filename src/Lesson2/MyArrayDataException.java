package Lesson2;

public class MyArrayDataException extends NumberFormatException {
    int n;
    int h;

    public MyArrayDataException(String s, int n, int h) {
        super(s);
        this.n = n;
        this.h = h;
    }


    public MyArrayDataException(String s) {
        super(s);
    }
}
