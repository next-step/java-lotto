public class Calculator {

    private static final String DEFAULT_FORMAT_REGEX = "^\\d+(?:\\s+[+\\-*/]\\s+\\d+)*$";

    private Calculator() {
    }

    public static int calculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력 값은 null이거나 공백일 수 없습니다.");
        }
        if (isNotValidFormat(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

        return 0;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static boolean isNotValidFormat(String input) {
        return !input.matches(DEFAULT_FORMAT_REGEX);
    }
}
