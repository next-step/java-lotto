package calculator;

import calculator.type.OperatorType;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputTokenizer {
    public static final String INVALID_INPUT_MESSAGE = "수식을 입력해 주세요.";
    public static final String DEFAULT_DELIMITER = " ";

    private final String[] values;

    public InputTokenizer(String input) {
        validate(input);

        values = input.split(DEFAULT_DELIMITER);
    }

    private void validate(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public Queue<Integer> numbers() {
        return Stream.of(values)
                .filter(this::isNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Queue<OperatorType> operators() {
        return Stream.of(values)
                .filter(token -> !isNumber(token))
                .map(OperatorType::findOperator)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
