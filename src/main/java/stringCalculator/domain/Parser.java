package stringCalculator.domain;

import static stringCalculator.enums.Regex.REGEX_BLANK;
import static stringCalculator.enums.Regex.REGEX_NUM_OR_OPERATOR;

public class Parser {

    public static String[] parseInput(String input) {
        validateString(input);
        return input.split(REGEX_BLANK.toString());
    }

    private static void validateString(String input) {
        // ^[0-9]+ 숫자로 시작되어야함
        // ()* 괄호 사이의 패턴이 반복
        if (!input.matches(REGEX_NUM_OR_OPERATOR.toString())) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
    }

}
