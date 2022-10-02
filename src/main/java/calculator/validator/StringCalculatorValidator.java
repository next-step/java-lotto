package calculator.validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorValidator {

    public static final String INPUT_VALIDATION_REGEXP = "^(([0-9]+|-[1-9][0-9]*) [+\\-*/] )*([0-9]+|-[1-9][0-9]*)$";

    public static void validateOrThrow(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다. null은 허용되지 않습니다.");
        }

        Pattern pattern = Pattern.compile(INPUT_VALIDATION_REGEXP);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다. 정규표현식: " + INPUT_VALIDATION_REGEXP);
        }
    }
}
