package calculator;

public class Parser {

    public static String[] parse(String input) {
        String[] tokens = split(input);
        validateSequence(tokens);
        return tokens;
    }

    private static String[] split(String input) {
        return input.trim().split("\\s+");
    }

    private static void validateSequence(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (invalidToken(tokens[i], i)) {
                throw new IllegalArgumentException("연산 순서가 바르지 않습니다");
            }
        }
    }

    private static boolean invalidToken(String token, int i) {
        if (i % 2 == 0 && token.matches("-?[0-9]+")) return false;
        if (i % 2 != 0 && token.matches("[+\\-*/]")) return false;
        return true;
    }
}

