package lotto.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotto.LottoMachine;

public class PaidValidator extends Validator {

    protected static final Pattern NUMERIC_PATTERN = Pattern.compile("[1-9][0-9]*");

    protected static final String NOT_NUMERIC_MESSAGE = "숫자만 입력해주세요!";

    protected static final String NOT_MULTIPLE_MESSAGE = LottoMachine.PAY + "의 배수가 아닙니다!";

    @Override
    public void validate(String amount) {
        super.validate(amount);
        checkNumeric(amount);
        checkMultiple(amount);
    }

    protected void checkNumeric(String amount) {
        Matcher matcher = NUMERIC_PATTERN.matcher(amount);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_NUMERIC_MESSAGE);
        }
    }

    protected void checkMultiple(String input) {
        if (Integer.parseInt(input) % LottoMachine.PAY != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_MESSAGE);
        }
    }
}
