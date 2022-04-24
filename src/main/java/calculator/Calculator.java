package calculator;

public class Calculator {

    public static int sum(int num, int num2) {
        return num + num2;
    }

    public static int minus(int num, int num2) {
        return num - num2;
    }

    public static int multiply(int num, int num2) {
        return num * num2;
    }

    public static int divide(int num, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }

        int result = num % num2;
        if (result > 0) {
            throw new IllegalArgumentException();
        }
        return num / num2;
    }
}
