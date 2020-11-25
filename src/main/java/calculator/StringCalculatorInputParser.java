package calculator;

import calculator.to.StringSumCalculatorInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorInputParser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("(//(?<delimiter>.)\n)?(?<parameter>.*)");
    private static final String DELIMITER_GROUP_LABEL = "delimiter";
    private static final String PARAMETER_GROUP_LABEL = "parameter";

    private StringCalculatorInputParser() {
    }

    public static StringSumCalculatorInput parse(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력값 포맷이 잘못 되었습니다.");
        }
        return new StringSumCalculatorInput.Builder()
                .delimiter(matcher.group(DELIMITER_GROUP_LABEL))
                .parameters(matcher.group(PARAMETER_GROUP_LABEL))
                .build();

    }
}
