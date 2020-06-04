package lotto.util;

import java.util.Arrays;

public class Split {

    private Split() {}

    public static String[] from(String text, String regx) {
        validateNullOrEmpty(text);
        return Arrays.stream(text.split(regx)).map(String::trim).toArray(String[]::new);
    }

    private static void validateNullOrEmpty(String text) {
        if(text == null || text.isEmpty()) {
            throw new IllegalArgumentException("입력된 텍스트가 비어있거나 NULL 입니다.");
        }
    }
}
