package lotto.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotto.LottoMachine;

public final class PaidValidator extends Validator {

    static final String NOT_NUMERIC_MESSAGE = "숫자만 입력해주세요!";

    static final String NOT_MULTIPLE_MESSAGE = LottoMachine.PAY + "의 배수가 아닙니다!";

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("[1-9][0-9]*");

    @Override
    public void validate(final String amount) {
        super.validate(amount);
        checkNumeric(amount);
        checkMultiple(amount);
    }

    private void checkNumeric(final String amount) {
        final Matcher matcher = NUMERIC_PATTERN.matcher(amount);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_NUMERIC_MESSAGE);
        }
    }

    private void checkMultiple(final String input) {
        if (Integer.parseInt(input) % LottoMachine.PAY != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_MESSAGE);
        }
    }
}
