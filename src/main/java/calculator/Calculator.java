package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final Pattern PERMIT_INPUT_REGEX = Pattern.compile("^[0-9+\\-*/ ]+$");

    public static int calculate(final String userInput) {
        final Matcher matcher = PERMIT_INPUT_REGEX.matcher(userInput);
        if (!matcher.find()) {
            throw new IllegalArgumentException("허용되지 않는 문자가 입력되었습니다.");
        }

        return Integer.parseInt(userInput);
    }
}
