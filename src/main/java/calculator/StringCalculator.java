package calculator;

import java.util.List;

public class StringCalculator {

    private final List<Integer> numbers;
    private final List<Operation> operations;

    public StringCalculator(String input) {
        validBlank(input);
        numbers = createNumbers(input);

        validOperation(input);
        operations = createOperations(input);
    }

    private void validBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private List<Integer> createNumbers(String input) {
        return null;
    }

    private void validOperation(String input) {
        if (!Operation.isOperation(input)) {
            throw new IllegalArgumentException();
        }
    }

    private List<Operation> createOperations(String input) {
        return null;
    }

    public List<Integer> numbers() {
        return null;
    }

}
