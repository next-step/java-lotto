package calculator;

public class Calculator {

    private final String[] strings;

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

    int calculateOperatorType(String operator, String a, String b) {
        if (operator.equals("+")) {
            return plus(a, b);
        }
        if (operator.equals("-")) {
            return minus(a, b);
        }
        if (operator.equals("*")) {
            return multiply(a, b);
        }
        if (operator.equals("/")) {
            return divide(a, b);
        }

        return 0;
    }

    int calculate() {
        String currentResult = strings[0];
        int currentIndex = 1;

        while (currentIndex < strings.length) {
            currentResult = String.valueOf(calculateOperatorType(strings[currentIndex], currentResult, strings[currentIndex + 1]));
            currentIndex += 2;
        }

        return Integer.parseInt(currentResult);
    }
}
