package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final String SEPARATOR = " ";

    private final String expr;

    public Calculator(String expr) {
        if (expr == null || expr.isBlank()) {
            throw new IllegalArgumentException("should not null or empty string");
        }
        this.expr = expr;
    }

    public Number calculate() {
        String[] tokens = expr.split(SEPARATOR);
        List<Number> numbers = getNumbers(tokens);
        List<Operator> operators = getOperators(tokens);

        Number result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).calculate(result, numbers.get(i + 1));
        }
        return result;
    }

    private List<Number> getNumbers(String[] tokens) {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < tokens.length; i += 2) {
            numbers.add(new Number(tokens[i]));
        }
        return numbers;
    }

    private List<Operator> getOperators(String[] tokens) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 1; i < tokens.length; i += 2) {
            operators.add(OperatorFactory.create(tokens[i]));
        }
        return operators;
    }
}
