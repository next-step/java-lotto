package domain;

public class Calculator {
    private int nowValue;
    private static final char add = '+';
    private static final char multiply  = '*';
    private static final char division = '/';
    private static final char minus = '-';

    public Calculator(int now) {
        this.nowValue = now;
    }

    private int add(int num) {
        return nowValue + num;
    }

    private int multiply(int num) {
        return nowValue * num;
    }

    private int division(int num) {
        return nowValue / num;
    }

    private int minus(int num) {
        return nowValue - num;
    }

    public int operation(int num, char symbol) {
        if (symbol == add)
            return add(num);
        else if (symbol == minus)
            return minus(num);
        else if (symbol == division)
            return division(num);
        else if (symbol == multiply)
            return multiply(num);
        else
            throw new IllegalArgumentException("잘못된 기호 입니다");
    }
}
