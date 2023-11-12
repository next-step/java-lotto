package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        List<String> operationItemList = extractExpressionItem(expression);

        int result = Integer.parseInt(operationItemList.get(0));
        for (int i = 1; i < operationItemList.size() - 1; i++) {
            result = calOperation(result, operationItemList.get(i), Integer.parseInt(operationItemList.get(i+1)));
        }

        return result;
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
     * @param operationSymbol 연산 타입 기호 +, -, *, /
     * @param rightOperand 우항
     *
     * @return 계산 결과
     */
    private static int calOperation(int leftOperand, String operationSymbol, int rightOperand) {
        if (operationSymbol.equals("+")) {
            return leftOperand + rightOperand;
        }
        else if (operationSymbol.equals("-")) {
            return leftOperand - rightOperand;
        }
        else if (operationSymbol.equals("*")) {
            return leftOperand * rightOperand;
        }
        else if (operationSymbol.equals("/")) {
            return leftOperand / rightOperand;
        }

        throw new IllegalArgumentException("알 수 없는 연산자 " + operationSymbol);
    }
}

/**
 * Operation의 연산 종류를 지정합니다.
 * 이름 뜻 그대로 덧셈인지, 뺄셈인지, 곱셈인지, 나눗셈인지를 지정합니다.
 */
enum OperationType {
    ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION,
}