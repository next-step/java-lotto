package domain;

public class Calculator {
    private static final char add = '+';
    private static final char multiply  = '*';
    private static final char division = '/';
    private static final char minus = '-';
    private int add(int num1, int num2) {
        return num1 + num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int division(int num1, int num2) {
        return num1 / num2;
    }

    private int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int operation(int num1, int num2, char symbol) {
        if (symbol == add)
            return add(num1, num2);
        else if (symbol == minus)
            return minus(num1, num2);
        else if (symbol == division)
            return division(num1, num2);
        else if (symbol == multiply)
            return multiply(num1, num2);
        else
            throw new IllegalArgumentException("잘못된 기호 입니다");
    }
}
