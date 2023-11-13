package calculator;

import java.util.Arrays;
import java.util.List;

/**
 * 문자열로 된 사칙연산 평가식을 평가하는 계산기입니다.
 */
public class StringCalculator {
    private StringCalculator() {
    }

    /**
     * 문자열로 된 사칙연산 평가식을 평가합니다.
     * 평가식 내의 각 연산은 결과가 정수여야 합니다.
     *
     * @param expression 문자열로된 사칙 연산식
     *
     * @return 평가 결과
     */
    public static int cal(String expression) {
        validateExpression(expression);

        List<String> operationItemList = extractExpressionItem(expression);

        int result = Integer.parseInt(operationItemList.get(0));
        for (int i = 1; i < operationItemList.size() - 1; i += 2) {
            result = calOperation(result, Operator.of(operationItemList.get(i)), Integer.parseInt(operationItemList.get(i+1)));
        }

        return result;
    }

    /**
     * 입력된 문자열이 정상 문자열인지 확인합니다.
     * 비정상일 경우 예외가 던져지며, 정상일 경우 통과됩니다.
     * @param expression
     */
    private static void validateExpression(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("입력 수식이 null입니다.");
        }

        if (expression.equals("")) {
            throw new IllegalArgumentException("입력 수식이 빈 문자열입니다.");
        }
    }

    /**
     * 사칙 연산 문자열에서 피연산자와 연산자를 추출합니다.
     * @param expression
     * @return
     */
    private static List<String> extractExpressionItem(String expression) {
        return Arrays.asList(expression.split(" "));
    }

    /**
     * 연산 하나를 계산합니다.
     *
     * @param leftOperand 좌항
     * @param operator 연산 타입
     * @param rightOperand 우항
     *
     * @return 계산 결과
     */
    private static int calOperation(int leftOperand, Operator operator, int rightOperand) {
        if (operator == Operator.ADDITION) {
            return leftOperand + rightOperand;
        }

        if (operator == Operator.SUBTRACTION) {
            return leftOperand - rightOperand;
        }

        if (operator == Operator.MULTIPLICATION) {
            return leftOperand * rightOperand;
        }

        // operator == Operator.DIVISON
        return leftOperand / rightOperand;
    }
}

/**
 * 연산 타입을 나타내는 enum 클래스
 * StringCalculator 안에서만 쓰입니다.
 */
enum Operator {
    /**
     * 덧셈 +
     * */
    ADDITION("+"),

    /**
     * 뺄셈 -
     */
    SUBTRACTION("-"),

    /**
     * 곱셈 *
     */
    MULTIPLICATION("*"),

    /**
     * 나눗셈 /
     */
    DIVISION("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator of(String symbol) {
        if (symbol.equals("+")) {
            return Operator.ADDITION;
        }

        if (symbol.equals("-")) {
            return Operator.SUBTRACTION;
        }

        if (symbol.equals("*")) {
            return Operator.MULTIPLICATION;
        }

        if (symbol.equals("/")) {
            return Operator.DIVISION;
        }

        throw new IllegalArgumentException("정의되지 않은 연산 기호: " + symbol);
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}