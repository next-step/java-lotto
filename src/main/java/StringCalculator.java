public class StringCalculator {

    public static int calculator(String text) {

        if (isNullOrEmpty(text)) {
            throw new IllegalArgumentException("문자열을 입력해주세요.");
        }

        return 0;
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
