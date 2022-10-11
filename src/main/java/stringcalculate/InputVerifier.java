package stringcalculate;

import java.util.regex.Pattern;

public class InputVerifier {
    private static final String BLANK = "\\s";
    private static final Pattern FILTER = Pattern.compile("^([0-9-+*/\\s]+)$");

    public static void validateInput(String input) {
        validateSplit(input);
        validateBlank(input);
        validateEmpty(input);
    }

    private static void validateSplit(String input) {
        if (!FILTER.matcher(input).matches()) {
            throw new WrongInputException("사칙연산 기호, 숫자, 앞의 둘을 포함한 공백외에는 입력 받을 수 없습니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new WrongInputException("값이 없는 빈 공백은 입력 받을 수 없습니다.");
        }
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new WrongInputException("빈 값은 입력 받을  수 없습니다.");
        }
    }
}
