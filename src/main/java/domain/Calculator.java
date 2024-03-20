package domain;

public class Calculator {
    private int nowValue;

    public int getNowValue() {
        return nowValue;
    }
    private static final String add = "+";
    private static final String multiply  = "*";
    private static final String division = "/";
    private static final String minus = "-";

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

    public int operation(int num, String symbol) {
        if (symbol.equals(add))
            return add(num);
        else if (symbol.equals(minus))
            return minus(num);
        else if (symbol.equals(division))
            return division(num);
        else if (symbol.equals(multiply))
            return multiply(num);
        else
            throw new IllegalArgumentException("잘못된 기호 입니다");
    }
}
