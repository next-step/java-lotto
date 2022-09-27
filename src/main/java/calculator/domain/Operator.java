package calculator.domain;

public class Operator {

    private static final int TWO_DIGIT_STRING = 2;
    private final String operator;

    public Operator(final String operator) {

        validateNullOrEmpty(operator);
        validateNoBlank(operator);
        validateMatchOperator(operator);
        this.operator = operator;
    }

    public void validateNullOrEmpty(final String operator) {

        if (operator == null || operator.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    /**
     * 입력한 문자열과 숫자가 빈칸으로 구분되지 않는 경우를 체크
     */
    private void validateNoBlank(final String operator) {

        if (operator.length() >= TWO_DIGIT_STRING && Operation.match(operator)) {
            throw new IllegalArgumentException("연산식의 숫자 또는 연산자 사이에 빈 공간이 없습니다.");
        }
    }

    private void validateMatchOperator(final String operator) {

        if (!Operation.match(operator)) {
            throw new IllegalArgumentException("+, -, * / 이외 다른 연산자는 불가능합니다.");
        }
    }

    public String getOperator() {

        return operator;
    }
}
