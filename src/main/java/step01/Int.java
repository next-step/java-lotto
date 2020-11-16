package step01;

public class Int {
    private static String NEGATIVE_EXCEPTION_MESSAGE = "음수는 계산할 수 없습니다.";

    public static boolean isParsed(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static void validateNotNegative(int input) {
        if (input < 0) {
            throw new RuntimeException(NEGATIVE_EXCEPTION_MESSAGE);
        }
    }
}
