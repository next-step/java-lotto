package stringcalculator;

public class StringCalculator {
    public int calculate(String text) {
        if (isNullOrBlank(text)) {
            throw new IllegalArgumentException("null 또는 빈문자열은 입력할 수 없습니다");
        }
        return 0;
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
}
