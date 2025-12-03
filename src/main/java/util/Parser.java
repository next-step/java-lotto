package util;

import controller.Calculator;
import domain.Number;
import domain.Operator;
import domain.OperatorFactory;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static final String EXPRESSION_PARSE_REGEX = "\\s+";

    public static Calculator parse(String input) {
        if (!isValidExpression(input)) {
            throw new IllegalArgumentException("유효하지 않은 수식입니다.");
        }

        String[] expression = input.split(EXPRESSION_PARSE_REGEX);
        return new Calculator(parseNumbers(expression), parseOperators(expression));
    }

    private static boolean isValidExpression(String expression) {
        return expression != null && !expression.isBlank();
    }

    private static List<domain.Number> parseNumbers(String[] expression) {
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < expression.length; i += 2) {
            numbers.add(new domain.Number(expression[i]));
        }

        return numbers;
    }

    private static List<Operator> parseOperators(String[] expression) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 1; i < expression.length - 1; i += 2) {
            operators.add(OperatorFactory.getOperator(expression[i]));
        }

        return operators;
    }
}
