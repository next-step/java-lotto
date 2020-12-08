package lotto.domain.validator;

public class NumberValidator extends Validator {

    static final String NOT_NUMERIC_MESSAGE = "숫자만 입력해주세요!";

    static final String NOT_POSITIVE_NUMBER = "이 숫자는 양수가 아닙니다!";

    @Override
    public void validate(String input) {
        super.validate(input);
        checkNumeric(input);
    }

    protected void checkNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_MESSAGE);
        }
    }

    protected void checkPositive(final String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER);
        }
    }
}
