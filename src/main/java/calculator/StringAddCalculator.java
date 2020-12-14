package calculator;

import calculator.domain.Delimiters;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String REGEX_POSITIVE_INTEGER = "^[0-9]*$";

    private final String mathExpression;
    private final Delimiters delimiters;

    public StringAddCalculator(String mathExpression) {
        this.mathExpression = mathExpression;
        this.delimiters = new Delimiters();
    }

    /**
     * 문자열을 구분자로 나누고 합계를 구합니다.
     * @return
     */
    public int splitAndSum() {
        if(this.isZeroInput(mathExpression)) {
            return 0;
        }
        return this.findSum(mathExpression.split(this.delimiters.toString()));
    }

    /**
     * 주어진 문자열이 null이거나 비어있는지 확인합니다.
     * @param mathExpression
     * @return
     */
    private boolean isZeroInput(String mathExpression) {
        return mathExpression == null || mathExpression.length() == 0;
    }

    /**
     * 문자열들을 양의 정수로 변경하여 합계를 구합니다.
     * @param splitMathExpression
     * @return
     */
    private int findSum(String[] splitMathExpression) {
        int sum = 0;
        for (String stringNumber : splitMathExpression) {
            int number = parsePositiveInteger(stringNumber);
            sum += number;
        }
        return sum;
    }

    /**
     * 문자열을 양의 정수로 반환합니다.
     * @param stringNumber
     * @return
     */
    private int parsePositiveInteger(String stringNumber) {
        if(stringNumber != null && isInteger(stringNumber)) {
            return Integer.parseInt(stringNumber);
        }
        throw new RuntimeException("숫자가 아니거나 음의 값입니다.");
    }

    /**
     * 문자열이 양의 정수인지 확인합니다.
     * @param stringNumber
     * @return
     */
    private boolean isInteger(String stringNumber) {
        return Pattern.matches(REGEX_POSITIVE_INTEGER, stringNumber);
    }
}
