package calculator.domain;


import java.util.LinkedList;
import java.util.List;

public class StringExpressionParser {

    public static Expression parse(String expression) {
        if (isBlank(expression)) {
            throw new IllegalArgumentException("null 또는 빈 문자열은 계산할 수 없습니다.");
        }
        return new Expression(convertExpression(expression));
    }

    private static boolean isBlank(String expression) {
        return expression == null || expression.isBlank();
    }

    private static List<ExpressionElement> convertExpression(String expression) {
        String[] elements = parseString(expression);
        if (isEvenNumber(elements.length)) {
            throw new IllegalArgumentException("연산 요소의 총 개수는 짝수일 수 없습니다.");
        }
        return convertElements(elements);
    }

    private static String[] parseString(String expression) {
        return expression.split(" ");
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    private static List<ExpressionElement> convertElements(String[] elements) {
        List<ExpressionElement> expressionElements = new LinkedList<>();
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            convertByIndex(expressionElements, element, i);
        }
        return expressionElements;
    }

    private static void convertByIndex(List<ExpressionElement> expressionElements, String element, int index) {
        if (isEvenNumber(index)) {
            Operand operand = convertToOperand(element);
            addOperand(expressionElements, operand);
            return;
        }
        Operator operator = convertToOperator(element);
        addOperator(expressionElements, operator);
    }

    private static Operand convertToOperand(String element) {
        Number number = new Number(element);
        return new Operand(number);
    }

    private static void addOperand(List<ExpressionElement> expressionElements, Operand operand) {
        expressionElements.add(operand);
    }

    private static Operator convertToOperator(String element) {
        return Operator.find(element);
    }

    private static void addOperator(List<ExpressionElement> expressionElements, Operator operator) {
        expressionElements.add(operator);
    }
}
