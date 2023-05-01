package calculator;

public class StringCalculator {
    private static final int ZERO = 0;

    public static final String DEFAULT_DELIMITER = " ";

    public static String[] split(String textInput) {
        isBlank(textInput);
        return isSizeEvenNumber(textInput.split(DEFAULT_DELIMITER));
    }

    private static void isBlank(String textInput) {
        if (textInput == null || textInput.isBlank()) {
            throw new IllegalArgumentException("입력된 문자열이 null 또는 공백 일 수 없습니다.");
        }
    }

    private static String[] isSizeEvenNumber(String[] values) {
        if (values.length % 2 == ZERO) {
            throw new IllegalArgumentException("분리된 문자열 배열 size 는 짝수 일 수 없습니다.");
        }
        return values;
    }

}
