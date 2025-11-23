package calculator;

public class StringCalculator {

    public static String[] split(String s) {
        return s.trim().split("\\s+");
    }

    public static boolean validateSequence(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (invalidToken(tokens[i], i)) {
                throw new IllegalArgumentException("연산 순서가 바르지 않습니다");
            }
        }
        return true;
    }

    private static boolean invalidToken(String token, int i) {
        if (i % 2 == 0 && token.matches("[1-9][0-9]*")) {
            return false;
        }
        if (i % 2 != 0 && token.matches("[+\\-*/]")) {
            return false;
        }
        return true;
    }
}
