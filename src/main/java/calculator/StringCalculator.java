package calculator;

public class StringCalculator {
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER = ",|:";

    public int add(String text) {
        // 더하는 로직 + 에러 체크 (+ 정규식)
        if (text == null || "".equals(text)) {
            return 0;
        }

        String[] numbers = text.split(",");

        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
