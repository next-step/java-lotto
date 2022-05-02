package calculator;

public class Calculator {

    private static final String DEFAULT_INPUT = "";

    private final String[] strings;

    public Calculator() {
        this(DEFAULT_INPUT);
    }

    public Calculator(String calculation) {
        Splitter splitter = new Splitter();
        this.strings = splitter.split(calculation);
    }

    int plus(String num1, String num2) {
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }

    int minus(String num1, String num2) {
        return Integer.parseInt(num1) - Integer.parseInt(num2);
    }

    int multiply(String num1, String num2) {
        return Integer.parseInt(num1) * Integer.parseInt(num2);
    }

    int divide(String numerator, String denominator) {
        return Integer.parseInt(numerator) / Integer.parseInt(denominator);
    }

    int calculateOperatorType(String operator, String num1, String num2) {
        if (operator.equals("+")) {
            return plus(num1, num2);
        }
        if (operator.equals("-")) {
            return minus(num1, num2);
        }
        if (operator.equals("*")) {
            return multiply(num1, num2);
        }
        if (operator.equals("/")) {
            return divide(num1, num2);
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
