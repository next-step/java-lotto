package stringcalculator.view;

import java.util.regex.Pattern;

public class InputView {
    static final Pattern INPUT_PATTERN = Pattern.compile("^[ 0-9+/*-]+$");

    public static String validate(final String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("null은 입력 불가");
        } else if (inputString.isBlank()) {
            throw new IllegalArgumentException("공백은 입력 불가");
        } else if (!INPUT_PATTERN.matcher(inputString).find()) {
            throw new IllegalArgumentException("숫자와 연산자 (+, -, /, *) 외 입력 불가");
        }
        return inputString;
    }
}
