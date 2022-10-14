package step1.domains;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return Stream.iterate(0, i -> i + 1)
                .limit(split.length)
                .filter(i -> i % 2 == 0)
                .map(i -> parseInt(split[i]))
                .collect(Collectors.toList());
    }

    private List<Operation> extractOperations(String[] split) {
        return Stream.iterate(0, i -> i + 1)
                .limit(split.length)
                .filter(i -> i % 2 == 1)
                .map(i -> Operation.find(split[i]))
                .collect(Collectors.toList());
    }

    private Integer parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다. 입력값: " + string);
        }
    }
}
