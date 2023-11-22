package stringCalculator.domain;

public class Parser {

    public static final String REGEX_BLANK = " ";
    public static final String REGEX_NUM_OR_OPERATOR = "^[0-9]+( [+\\-*/] [0-9]+)*$";

    public static String[] parseInput(String input) {
        validateString(input);
        return input.split(REGEX_BLANK);
    }

    private static void validateString(String input) {
        // ^[0-9]+ 숫자로 시작되어야함
        // ()* 괄호 사이의 패턴이 반복
        if (!input.matches(REGEX_NUM_OR_OPERATOR)) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
    }

}
