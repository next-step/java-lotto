package calculator.controller;

import calculator.domain.Operator;
import calculator.domain.Splitter;
import calculator.util.Validator;

import java.util.List;

public class CalculatorController {

    public CalculatorController(String expression) {
        Validator.validateExpression(expression);
    }

    public int calculate(String expression) {
        List<Integer> numbers = splitNumbers(expression);
        List<Operator> operators = SplitOperators(expression);

        int result = numbers.get(0);

        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            int nextNumber = numbers.get(i + 1);

            result = operator.apply(result, nextNumber);
        }

        return result;
    }

    private static List<Operator> SplitOperators(String expression) {
        return Splitter.splitOperators(expression);
    }

    private static List<Integer> splitNumbers(String expression) {
        return Splitter.splitNumbers(expression);
    }
}
