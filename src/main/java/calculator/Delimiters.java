package calculator;

import java.util.Arrays;

public enum Delimiters {

    COMMA(','),
    SEMI_COLON(':');

    private final char value;

    Delimiters(char value) {
        this.value = value;
    }

    public static void validateExistDelimiter(char inputDelimiter) {
        Arrays.stream(Delimiters.values())
                .filter(delimiter -> delimiter.value == inputDelimiter)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("구분자를 입력해주세요. : " + inputDelimiter));
    }
}
