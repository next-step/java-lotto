package calculator.validator;

import calculator.util.StringUtils;

public class StringValidator {
    public static void validateForBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력값을 입력해주세요");
        }
    }
}
