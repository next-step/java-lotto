import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Calculator {
    private final static String INPUT_REGEX = " ";

    private final static String DIGIT_REGEX = "^[0-9]*$";

    private final static String ILLEGAL_OPERATOR_EXCEPTION = "잘못된 연산자를 입력했습니다.";

    public static int run(String inputString) {
        List<String> inputs = List.of(inputString.split(INPUT_REGEX));
        List<Integer> digits = extractDigits(inputs);
        List<String> operators = extractOperators(inputs);
        int result = digits.get(0);
        for (int i = 0; i < operators.size(); i++) {
            int nextOperand = digits.get(i + 1);
            String operator = operators.get(i);
            result = calculate(result, nextOperand, operator);
        }
        return result;
    }

    private static int calculate(int firstOperand, int secondOperand, String operator) throws IllegalArgumentException {
        if (Objects.equals(operator, "+")) {
            return firstOperand + secondOperand;
        }

        if (Objects.equals(operator, "-")) {
            return firstOperand - secondOperand;
        }

        if (Objects.equals(operator, "*")) {
            return firstOperand * secondOperand;
        }

        if (Objects.equals(operator, "/")) {
            return firstOperand / secondOperand;
        }

        throw new IllegalArgumentException(ILLEGAL_OPERATOR_EXCEPTION);
    }

    private static List<String> extractOperators(List<String> inputs) {
        return inputs.stream().filter(input -> !isDigit(input)).collect(Collectors.toList());
    }

    private static List<Integer> extractDigits(List<String> inputs) {
        return inputs.stream()
                .filter(Calculator::isDigit)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isDigit(String inputString) {
        return inputString.matches(DIGIT_REGEX);
    }
}
