package lotto.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class PurchaseMoney {
    private static final String MESSAGE_POSITIVE_NUMBER_ONLY = "구입금액은 양수만 입력할 수 있습니다.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+(,\\d+)*$");

    private int value;

    public PurchaseMoney(String value) {
        validateStringConstructor(value);
        this.value = parseInt(value);
    }

    public PurchaseMoney(int value) {
        validateIntConstructor(value);
        this.value = value;
    }

    private void validateStringConstructor(String value) {
        Matcher numberArrayCheckResult = NUMBER_PATTERN.matcher(value);
        if (!numberArrayCheckResult.find()) {
            throw new IllegalArgumentException(MESSAGE_POSITIVE_NUMBER_ONLY);
        }
    }

    private void validateIntConstructor(int value) {
        if(value < 0) {
            throw new IllegalArgumentException(MESSAGE_POSITIVE_NUMBER_ONLY);
        }
    }

    public int getValue() {
        return value;
    }
}
