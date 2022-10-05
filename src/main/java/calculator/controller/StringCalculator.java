package calculator.controller;

import calculator.model.Number;
import calculator.model.Operator;
import calculator.view.Input;
import calculator.view.Output;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String INPUT_ERROR_MESSAGE = "입력값으로 NULL 혹은 빈값은 입력할 수 없습니다,";
    private static final String DELIMITER = " ";

    public int calculator() {
        String input = Input.getInput();
        List<String> splitResult = getOperations(input);
        List<Number> numbers = splitResult.stream()
                .filter(Number::isInteger)
                .map(Number::new)
                .collect(Collectors.toList());
        List<Operator> operators = splitResult.stream()
                .filter(it -> !Number.isInteger(it))
                .map(Operator::getProperOperator)
                .collect(Collectors.toList());
        int resultValue = calculate(numbers, operators);
        Output.printResult(resultValue);
        return resultValue;
    }

    private List<String> getOperations(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return List.of(input.split(DELIMITER));
    }

    private int calculate(List<Number> numbers, List<Operator> operators) {
        Number result = numbers.get(0);
        int size = operators.size();
        for (int i = 0; i < size; i++) {
            Operator operator = operators.get(i);
            Number number = numbers.get(i + 1);
            result = operator.operate(result, number);
        }
        return result.getNumber();
    }

}
