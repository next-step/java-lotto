package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Element> parseExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        String[] elements = expression.split(" ");
        return parseElements(elements);
    }

    private static List<Element> parseElements(String[] elements) {
        List<Element> parsedElements = new ArrayList<Element>();
        parsedElements.add(new Element(Operator.START, parseOperand(elements[0])));
        for (int i = 1; i < elements.length; i += 2) {
            Operator operator = parseOperator(elements[i]);
            int operand = parseOperand(elements[i + 1]);
            parsedElements.add(new Element(operator, operand));
        }
        return parsedElements;
    }

    private static int parseOperand(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자는 숫자여야 합니다.");
        }
    }

    private static Operator parseOperator(String element) {
        try {
            return Operator.of(element);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("연산자는 +, -, *, /만 가능합니다.");
        }
    }
}
