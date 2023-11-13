package calculator.controller;

import calculator.domain.Splitter;
import calculator.util.Validator;

import java.util.List;

public class CalculatorController {

    public CalculatorController(String expression) {
        Validator.validateExpression(expression);
    }

    public void calculate(String expression) {
        List<Integer> numbers = Splitter.splitNumbers(expression);
        List<String> operators = Splitter.splitOperators(expression);
    }
}
