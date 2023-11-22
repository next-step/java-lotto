package stringCalculator.domain;

public class Parser {
    public static String[] parseInput(String input) {
        validateString(input);
        return input.split(" ");
    }

    private static void validateString(String input) {
        // ^[0-9]+ 숫자로 시작되어야함
        // ()* 괄호 사이의 패턴이 반복
        if (!input.matches("^[0-9]+( [+\\-*/] [0-9]+)*$")) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
    }

}
