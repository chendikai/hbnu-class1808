package cn.hbnu.edu.exception;

public class NullPointerExceptionDemo {
    int i = 9;
    public static void main(String[] args) {
        NullPointerExceptionDemo nullPointerExceptionDemo = new NullPointerExceptionDemo();
        nullPointerExceptionDemo = null;
        System.out.println(nullPointerExceptionDemo.i);

    }
}
