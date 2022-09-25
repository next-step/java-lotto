package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final String OPERATOR = "[+\\-*/]";
    private static final Pattern REGULAR_OPERATOR = Pattern.compile(OPERATOR);
    private static final String EMPTY_STRING = " ";
    private static final int INDEX_NEXT_OPERATOR = 2;
    private static final int TWO_DIGIT_STRING = 2;

    private List<String> input;

    private StringAddCalculator(final String input) {

        validate(input);
        this.input = splitToList(input);
    }

    public static StringAddCalculator from(final String input) {

        return new StringAddCalculator(input);
    }

    private void validate(final String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    private List<String> splitToList(final String input) {

        return Arrays.stream(input.split(EMPTY_STRING))
                .collect(Collectors.toList());
    }

    public int calculator() {

        validateNoBlank();
        final int result = countByOperator();
        validateNotSupportOperater(result);
        validateWrongInput();

        return finalOperate(result);
    }

    private void validateNoBlank() {

        for (String str : this.input) {
            validateNoBlank(str);
        }
    }

    /**
     * 입력한 문자열과 숫자가 빈칸으로 구분되지 않는 경우를 체크
     * @param str
     */
    private void validateNoBlank(final String str) {

        if (str.length() >= TWO_DIGIT_STRING) {
            validateDigitOperater(str);
        }
    }

    private void validateDigitOperater(final String str) {

        if (match(str)) {
            throw new IllegalArgumentException("연산식의 숫자 또는 연산자 사이에 빈 공간이 없습니다.");
        }
    }

    private int countByOperator() {

        int result = 0;
        for (String str : input) {
            if (match(str)) result++;
        }
        return result;
    }

    private boolean match(final String str) {

        return REGULAR_OPERATOR.matcher(str).find();
    }

    /**
     * 사칙연산 개수가 0이면 익센션 처리
     * @param operatorCount
     */
    private void validateNotSupportOperater(final int operatorCount) {

        if (operatorCount == 0) {
            throw new IllegalArgumentException("+, -, * / 이외 다른 연산자는 불가능합니다.");
        }
    }

    /**
     * 숫자와 연산자의 수는 짝수가 되면 안되기 떄문에 2로 나누었을때 나머지가 0이면 익셉션 처리
     */
    private void validateWrongInput() {

        final int remainder = Math.floorMod(this.input.size(), 2);
        if (remainder == 0) {
            throw new IllegalArgumentException("계산기를 잘못 입력하였습니다.");
        }
    }

    private int finalOperate(final int result) {

        int index = 1;
        for (int i = 0; i < result; i++) {
            final String operator = this.input.get(index);
            int value = operate(operator, beforeNumber(index), afterNumber(index));
            saveAfterIndex(index, value);
            index += INDEX_NEXT_OPERATOR; // 그 다음 인덱스로 이동
        }
        return convertInt(findLastIndex());
    }

    private String afterNumber(int index) {
        return input.get(index + 1);
    }

    private String beforeNumber(int index) {
        return input.get(index - 1);
    }

    private int operate(final String operation, final String target1, final String target2) {

        final int number1 = convertInt(target1);
        final int number2 = convertInt(target2);
        return Operation.from(operation).apply(number1, number2);
    }

    private void saveAfterIndex(final int index, final int value) {

        this.input.set(index + 1, String.valueOf(value));
    }

    private String findLastIndex() {

        return this.input
                .get(this.input.size() - 1);
    }

    private int convertInt(final String str) {

        return Integer.parseInt(str);
    }
}
