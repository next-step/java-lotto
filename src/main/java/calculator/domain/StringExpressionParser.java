package calculator.domain;


import java.util.ArrayList;
import java.util.List;

public class StringExpressionParser {

    public static Expression parse(String stringExpression) {
        if (isBlank(stringExpression)) {
            throw new IllegalArgumentException("null 또는 빈 문자열은 계산할 수 없습니다.");
        }
        String[] stringElements = parseByEmptySpace(stringExpression);
        if (isEvenNumber(stringElements.length)) {
            throw new IllegalArgumentException("연산 요소의 총 개수는 짝수일 수 없습니다.");
        }
        return convertToExpression(stringElements);
    }

    private static boolean isBlank(String expression) {
        return expression == null || expression.isBlank();
    }

    private static String[] parseByEmptySpace(String expression) {
        return expression.split(" ");
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    private static Expression convertToExpression(String[] stringElements) {
        List<Operand> operands = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();
        Operand firstOperand = new Operand(stringElements[0]);
        operands.add(firstOperand);
        for (int i = 1; i < stringElements.length; i += 2) {
            Operator operator = Operator.find(stringElements[i]);
            operators.add(operator);
            Operand operand = new Operand(stringElements[i + 1]);
            operands.add(operand);
        }
        return new Expression(operands, operators);
    }
}
