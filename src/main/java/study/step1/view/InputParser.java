package study.step1.view;

public class InputParser {

    private static final String DELIMITER = " ";

    public static String[] parse(String input) {
        validate(input);
        return input.split(DELIMITER);
    }

    private static void validate(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException("InputParserError: 입력값 오류(빈 값 혹은 공백)");
        }
    }

    private static boolean isValid(String input) {
        return input != null && !input.isEmpty();
    }
}
