package calculator;

import calculator.to.StringSumCalculatorInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorInputParser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("(//(.)\n)?(.*)");
    private static final int DELIMITER_GROUP = 2;
    private static final int PARAMETER_GROUP = 3;

    private StringCalculatorInputParser() {
    }

    public static StringSumCalculatorInput parse(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력값 포맷이 잘못 되었습니다.");
        }
        return new StringSumCalculatorInput.Builder()
                .delimiter(matcher.group(DELIMITER_GROUP))
                .parameters(matcher.group(PARAMETER_GROUP))
                .build();

    }
}
