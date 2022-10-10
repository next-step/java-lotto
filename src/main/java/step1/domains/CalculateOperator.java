package step1.domains;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CalculateOperator {
    private static final String NULL_OR_EMPTY_STRING_MSG = "null이나 빈 문자열이 올 수 없습니다.";
    private static final String DEFAULT_DELIMITER = " ";

    private final List<Integer> numbers;
    private final List<Operation> operations;

    public CalculateOperator(String input) {
        validateInputString(input);

        String[] split = input.split(DEFAULT_DELIMITER);

        this.numbers = extractNumbers(split);
        this.operations = extractOperations(split);
    }

    public int calculate() {
        AtomicInteger operationIndex = new AtomicInteger();

        return numbers.stream()
                .reduce((n, m) -> {
                    Operation operation = operations.get(operationIndex.getAndIncrement());
                    return operation.calculate(n, m);
                })
                .orElse(0);
    }

    private void validateInputString(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_STRING_MSG);
        }
    }

    private List<Integer> extractNumbers(String[] split) {
        return Arrays.stream(split)
                .filter(this::isNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Operation> extractOperations(String[] split) {
        return Arrays.stream(split)
                .filter(s -> !isNumeric(s))
                .map(Operation::parse)
                .collect(Collectors.toList());
    }

    private boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
