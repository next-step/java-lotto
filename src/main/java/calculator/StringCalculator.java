package calculator;

import calculator.util.StringUtils;

public class StringCalculator {

    private StringCalculator() {
        throw new UnsupportedOperationException("유틸 클래스는 생성할 수 없습니다.");
    }

    public static int calculate(final String input) {
        validateInput(input);
        return 0;
    }

    private static void validateInput(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력값에 null 또는 공백만 존재하여 계산을 할 수 없습니다.");
        }
    }
}
