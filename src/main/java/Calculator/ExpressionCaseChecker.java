package Calculator;

import Calculator.exception.WrongPlaceNumberOrOperatorException;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ExpressionCaseChecker {

    private static final String OPERATOR_DELIMITER = "[+\\-*/]";
    private static final String NUMBER_DELIMITER = "\\d*(\\.\\d+)?";

    private static final Pattern OPERATOR_PATTERN = Pattern.compile(OPERATOR_DELIMITER);
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_DELIMITER);

    private ExpressionCaseChecker() {
    }

    public static void checkExpression(String[] splitExp) {
        checkPossibleExpression(splitExp);
    }

    private static void checkPossibleExpression(String[] splitExp) {
        checkExpressionLengthOdd(splitExp);

        // TODO
        Stream<String> stream = Arrays.stream(splitExp);

        // 홀수자리는 무조건 숫자, 짝수자리는 무조건 연산자가 나와야함.
        for (int i = 0; i < splitExp.length; ++i) {
            checkWrongPlace(splitExp, i);
        }
    }

    private static void checkWrongPlace(String[] splitExp, int i) {
        if ((i % 2 == 0) && (OPERATOR_PATTERN.matcher(splitExp[i]).matches())) {
            throw new WrongPlaceNumberOrOperatorException("피연산자 자리에 연산자가 존재합니다.");
        } else if ((i % 2 == 1) && (NUMBER_PATTERN.matcher(splitExp[i]).matches())) {
            throw new WrongPlaceNumberOrOperatorException("연산자 자리에 피연산자가 존재합니다.");
        }
    }

    private static void checkExpressionLengthOdd(String[] splitExp) {
        if (splitExp.length % 2 == 0) {
            throw new WrongPlaceNumberOrOperatorException();
        }
    }
}
