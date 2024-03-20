package calculator;

public class Validator {

    private static final String NUMBER_REGEX = "\\d+";

    public static void validateInputNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 문자열은 입력할 수 없습니다.");
        }
    }

    public static int validateInputIsNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return convertStringToInt(input);

    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
