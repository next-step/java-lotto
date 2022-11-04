package calculator.service;

import calculator.domain.Number;
import calculator.domain.Operator;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorService {

    private static final String INPUT_ERROR_MESSAGE = "입력값으로 NULL 혹은 빈값은 입력할 수 없습니다,";
    private static final String DELIMITER = " ";

    public List<String> getOperations(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        return List.of(input.split(DELIMITER));
    }

    public List<Number> getNumbers(List<String> splitResult) {
        return splitResult.stream()
            .filter(Number::isInteger)
            .map(Number::new)
            .collect(Collectors.toList());
    }

    public List<Operator> getOperators(List<String> splitResult) {
        return splitResult.stream()
            .filter(it -> !Number.isInteger(it))
            .map(Operator::getProperOperator)
            .collect(Collectors.toList());
    }

    public int calculate(List<Number> numbers, List<Operator> operators) {
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
