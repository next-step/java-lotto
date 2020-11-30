package lotto.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmountValidator extends Validator {

    public static final Pattern NUMERIC_PATTERN = Pattern.compile("[1-9][0-9]*");

    public static final String NOT_NUMERIC_MESSAGE = "숫자만 입력해주세요!";

    public static final int MULTIPLE = 1000;

    public static final String NOT_MULTIPLE_MESSAGE = MULTIPLE + "의 배수가 아닙니다!";

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
        if (Integer.parseInt(input) % MULTIPLE != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_MESSAGE);
        }
    }
}
