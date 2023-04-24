package calculator.Model;

import calculator.Enums.Operator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final int INITIAL_NUMBER = 0;

    private final List<Number> numbers;
    private final List<Operator> operators;

    public Calculator() {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public Calculator(CalculatorElements calculatorElements) {
        numbers = calculatorElements.numbers();
        operators = calculatorElements.operators();
    }

    public int execute() {
        Number result = numbers.get(INITIAL_NUMBER);
        for (int i = 0; i < numbers.size() - 1; i++) {
            result = calculate(result, operators.get(i), numbers.get(i + 1));
        }

        return result.value();
    }

    public Number calculate(Number numberBeforeOperator, Operator operator, Number numberAfterOperator) {
        return operator.execute(numberBeforeOperator, numberAfterOperator);
    }
}

