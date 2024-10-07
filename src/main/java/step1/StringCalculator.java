package step1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Map<String, Operator> operatorMap = Map.of(
            "+", Operator.PLUS,
            "-", Operator.MINUS,
            "*", Operator.MULTIPLY,
            "/", Operator.DIVIDE
    );
    private static final String DELIMITER = " ";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public static int run(String input) {
        if (!hasText(input)) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        String[] splitValues = split(input);
        validate(splitValues);
        return calculate(splitValues);
    }

    private static boolean hasText(String input) {
        return input != null && !input.isEmpty() && !input.isBlank();
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    private static void validate(String[] splitValues) {
        boolean hasInvalidValue = Arrays.stream(splitValues)
                .anyMatch(value -> !isOperator(value) && !NUMBER_PATTERN.matcher(value).matches());

        if (hasInvalidValue) {
            throw new IllegalArgumentException("숫자 또는 연산자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public static boolean isOperator(String operator) {
        return List.of("+", "-", "*", "/").contains(operator);
    }

    private static int calculate(String[] splitValues) {
        Queue<Integer> numbers = NumberExtractor.extract(splitValues);
        Queue<String> operators = OperatorExtractor.extract(splitValues);

        int result = numbers.poll();
        while (!operators.isEmpty()) {
            String operator = operators.poll();
            int number = numbers.poll();
            result = operate(result, number, operator);
        }

        return result;
    }

    private static int operate(int x, int y, String operator) {
        return operatorMap.get(operator).calculate(x, y);
    }

}
