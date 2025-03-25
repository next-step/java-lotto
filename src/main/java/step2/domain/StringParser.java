package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    public ExpressionElement splitExpression(String expression) {
        validateExpression(expression);
        List<String> elements = getElements(expression);

        return new ExpressionElement(getNumbers(elements), getOperators(elements));
    }

    private void validateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열이거나 null 입니다.");
        }
    }

    private List<String> getElements(String expression) {
        return Arrays.asList(expression.split(" "));
    }

    private List<String> getOperators(List<String> elements) {
        List<String> operators = new ArrayList<>();

        for (String element : elements) {
            if (isOperator(element)) {
                operators.add(element);
            }
        }

        return operators;
    }

    private List<Integer> getNumbers(List<String> elements) {
        List<Integer> numbers = new ArrayList<>();

        for (String element : elements) {
            if (isNumber(element)) {
                numbers.add(Integer.parseInt(element));
            }
        }

        return numbers;
    }

    private boolean isOperator(String element) {
        return element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/");
    }

    private boolean isNumber(String element) {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
