package stringcaculator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import stringcaculator.domain.Number;
import stringcaculator.domain.Numbers;
import stringcaculator.util.StringParser;

public class Calculator {

    private static Calculator instance;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public int calculate(String expression) {
        if (isEmptyExpression(expression)) {
            return 0;
        }
        String[] splitExpression = splitExpression(expression);
        List<Number> numbersByExpression = Arrays.stream(splitExpression)
            .map(Number::new)
            .collect(Collectors.toList());
        Numbers numbers = new Numbers(numbersByExpression);
        return numbers.sum();
    }

    private boolean isEmptyExpression(String expression) {
        return expression == null || expression.trim().length() == 0 || expression.isEmpty();
    }

    private String[] splitExpression(String expression) {
        return StringParser.splitExpression(expression);
    }
}
