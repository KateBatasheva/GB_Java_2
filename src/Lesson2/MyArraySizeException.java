package Lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    int n;
    int h;
    public MyArraySizeException(String message) {
        super(message);
    }
    public MyArraySizeException(String message, int n) {
        super(message);
        this.n = n;
    }
    public MyArraySizeException(String message, int n, int h) {
        super(message);
        this.n = n;
        this.h = h;
    }

}
