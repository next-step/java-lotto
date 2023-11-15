package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

    private static final String DELIMITER = " ";

    public static List<Integer> splitNumbers(String expression) {
        return Arrays.stream(split(expression))
                .filter(Splitter::isNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Operator> splitOperators(String expression) {
        return Arrays.stream(split(expression))
                .filter(Splitter::isOperator)
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
