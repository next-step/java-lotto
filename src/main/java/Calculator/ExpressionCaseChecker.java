package Calculator;

import Calculator.exception.OnlyNumberException;
import Calculator.exception.OnlyOperatorException;
import Calculator.exception.WrongPlaceNumberOrOperatorException;

import java.util.regex.Pattern;

public class ExpressionCaseChecker {

    private static final String OPERATOR_DELIMITER = "[+\\-*/]";
    private static final String NUMBER_DELIMITER = "\\d*(\\.\\d+)?";

    private static final Pattern OPERATOR_PATTERN = Pattern.compile(OPERATOR_DELIMITER);
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_DELIMITER);

    private ExpressionCaseChecker() {
    }

    static void checkOnlyNumber(String[] splitExp) {
        boolean isOnlyNumberExp = true;

        for (String exp : splitExp) {
            // 연산자가 하나라도 존재하는지 체크
            if (NUMBER_PATTERN.matcher(exp).matches() == false) {
                isOnlyNumberExp = false;
            }
        }

        if (isOnlyNumberExp == true) {
            throw new OnlyNumberException("수식에 피연산자만 존재합니다.");
        }
    }

    static void checkOnlyOperator(String[] splitExp) {
        boolean isOnlyOperatorExp = true;

        for (String exp : splitExp) {
            // 피연산자가 하나라도 존재하는지 체크
            if (OPERATOR_PATTERN.matcher(exp).matches() == false) {
                isOnlyOperatorExp = false;
            }
        }

        if (isOnlyOperatorExp == true) {
            throw new OnlyOperatorException("수식에 연산자만 존재합니다.");
        }
    }

    static void checkPossibleExpression(String[] splitExp) {
        splitExpLengthIsOdd(splitExp);

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

    static void splitExpLengthIsOdd(String[] splitExp) {
        if (splitExp.length % 2 == 0) {
            throw new WrongPlaceNumberOrOperatorException();
        }
    }
}
