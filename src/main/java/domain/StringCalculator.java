package domain;

import java.util.*;

public class StringCalculator {

    private List<String> input;
    private Calculator calculator;

    public StringCalculator(List<String> input) {
        this.input = input;
    }

    private static Map<String, Calculator> getStringCalculatorMap() {
        Map<String, Calculator> operatorMap = new HashMap<>();
        operatorMap.put("+", new Addition());
        operatorMap.put("-", new Subtraction());
        operatorMap.put("*", new Multiplication());
        operatorMap.put("/", new Division());
        return operatorMap;
    }

    public int calculator() {
        Map<String, Calculator> operatorMap = getStringCalculatorMap();
        int result = Integer.parseInt(input.get(0));
        for (int i = 1; i < input.size() - 1; i += 2) {
            calculator = operatorMap.get(validate(input.get(i)));
            result = calculator.calculator(result, Integer.parseInt(input.get(i + 1)));
        }
        return result;
    }

    public int calculator2() {
        int result = Integer.parseInt(input.get(0));
        for (int i = 1; i < input.size() - 1; i += 2) {
            BasicOperator basicOperator = BasicOperator.mapping(validate(String.valueOf(input.get(i))));
            result = basicOperator.apply(result, Integer.parseInt(input.get(i + 1)));
        }
        return result;
    }

    public String validate(String operator) {
        Set<String> validOperators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        if (!validOperators.contains(operator)) {
            throw new IllegalArgumentException("사칙연산 기호는 +, -, *, / 만 가능합니다.");
        }
        return operator;
    }
}
