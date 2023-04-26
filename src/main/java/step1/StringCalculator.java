package step1;

import step1.operation.MinusOperation;
import step1.operation.Operation;
import step1.operation.PlusOperation;

import java.util.Map;

public class StringCalculator {

    private static final Map<String, Operation> operations =
            Map.of("+", new PlusOperation(),
                    "-", new MinusOperation());
    private static final String DELIMITER = " ";

    public static Integer calculate(String input) {
        validateNullOrBlank(input);
        String[] split = split(input);
        Integer sum = null;
        Operation operation = null;
        for (String string : split) {
            if (sum == null) {
                sum = Integer.parseInt(string);
            } else if (operations.containsKey(string)) {
                operation = operations.get(string);
            } else {
                sum = operation.operate(sum, Integer.parseInt(string));
            }
        }
        return sum;
    }

    private static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값은 null 이거나 공백일 수 없습니다.");
        }
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

}
