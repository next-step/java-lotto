package calculator;

import java.util.List;

public class Tokenizer {
    public static final String DELIMITER = " ";

    public static List<String> tokenize(String input) {
        validate(input);
        return List.of(input.split(DELIMITER));
    }

    private static void validate(String input) {
        if (!input.trim().contains(DELIMITER)) {
            throw new IllegalArgumentException("공백을 기준으로 입력해주세요.");
        }
    }
}
