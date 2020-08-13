package util;

import java.util.Arrays;

public class StringUtil {

    public static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "문자열에 음수값이 포함되어 있습니다.";

    public static int[] textToInt(String[] texts) {
      return Arrays.stream(texts).mapToInt(text -> toPositiveNumber(text)).toArray();
    }

    public static int toPositiveNumber(String text) {
        int number = Integer.parseInt(text);
        if(number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
        return number;
    }


}
