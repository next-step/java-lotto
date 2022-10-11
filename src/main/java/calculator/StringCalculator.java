package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public static List<String> split(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("입력값에 null 이거나 빈 공백 문자는 올수없습니다.");
        }
        return Arrays.asList(text.split(DELIMITER));
    }
}
