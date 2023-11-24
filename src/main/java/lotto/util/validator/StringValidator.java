package lotto.util.validator;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    private StringValidator() {
    }

    public static void validateBlank(String value, String target) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(String.format("%s에 공백은 입력할 수 없습니다.", target));
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException(String.format("%s에 공백은 입력할 수 없습니다.", target));
        }
    }

    public static void validateNumeric(String value, String target) {
        if (!isNumber(value)) {
            throw new IllegalArgumentException(String.format("%s에는 숫자만 입력해야합니다.", target));
        }
    }

    public static void validateIntegerRange(String value, String target) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s에는 정상적인 범위 내의 숫자만 입력해야합니다.", target));
        }
    }

    public static boolean isNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }
}
