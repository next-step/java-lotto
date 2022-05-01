package calculator;

public class Calculator {

    private static final int PLUS = 1;
    private static final int MINUS = 2;
    private static final int MULTIPLY = 3;
    private static final int DIVIDE = 4;

    private String[] strings;
    public Calculator() {
        this("");
    }

    public Calculator(String s) {
        Splitter splitter = new Splitter();
        this.strings = splitter.split(s);
    }

    int plus(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    int minus(String a, String b) {
        return Integer.parseInt(a) - Integer.parseInt(b);
    }

    int multiply(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    int divide(String a, String b) {
        return Integer.parseInt(a) / Integer.parseInt(b);
    }

    int operatorType(String operator) {
        if (operator.equals("+")) {
            return PLUS;
        }
        if (operator.equals("-")) {
            return MINUS;
        }
        if (operator.equals("*")) {
            return MULTIPLY;
        }
        if (operator.equals("/")) {
            return DIVIDE;
        }

        return 0;
    }
}
