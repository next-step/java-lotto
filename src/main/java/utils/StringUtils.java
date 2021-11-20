package utils;

import java.text.MessageFormat;

public interface StringUtils {

    String CONVERT_EXCEPTION_MESSAGE_FORMAT = "{0}은 양수로 변환할 수 없습니다.";

    static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    static Integer parsePositiveNumber(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(
                MessageFormat.format(CONVERT_EXCEPTION_MESSAGE_FORMAT, input));
        }

        int number = Integer.parseInt(input);

        if (number < 0) {
            throw new IllegalArgumentException(
                MessageFormat.format(CONVERT_EXCEPTION_MESSAGE_FORMAT, input)
            );
        }

        return number;
    }

}
