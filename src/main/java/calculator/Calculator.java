package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private static final String DELIMITER = " ";
    private static final Pattern PATTERN = Pattern.compile("(?:[0-9]+\\s[-+/*]\\s)*[0-9]+");

    public static int calculate(String input) {

        Calculator.validateExpression(input);

        List<Operator> operators = Calculator.splitOperators(input);
        List<Integer> numbers = Calculator.splitNumbers(input);

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);

            result = operator.operate(result, numbers.get(i + 1));
        }
        return result;
    }

    public static List<Integer> splitNumbers(String expression) {
        return Arrays.stream(split(expression))
                .filter(Calculator::isNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Operator> splitOperators(String expression) {
        return Arrays.stream(split(expression))
                .filter(Calculator::isOperator)
                .map(Operator::findByOperator)
                .collect(Collectors.toList());
    }

    private static String[] split(String expression) {
        return expression.split(DELIMITER);
    }

    private static boolean isNumber(String str) {
        return str.matches("\\d");
    }

    private static boolean isOperator(String str) {
        return str.matches("[+\\-*/]");
    }

    public static void validateExpression(String expression) {

        if (isNullOrEmpty(expression)) {
            throw new IllegalArgumentException("빈값이 입력되었습니다.");
        }

        if (isNotMatchPattern(expression)) {
            throw new IllegalArgumentException("입력값이 형식에 맞지 않습니다.");
        }
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isBlank();
    }

    private static boolean isNotMatchPattern(String expression) {
        return !PATTERN.matcher(expression).matches();
    }
}
