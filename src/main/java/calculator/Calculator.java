package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private static final String DELIMITER = " ";

    public static int calculate(String input) {

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

}
