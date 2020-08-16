package util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

    public static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "문자열에 음수값이 포함되어 있습니다.";

    private StringUtil() {
    }

    public static List<Integer> textToInt(String[] texts) {
      return Stream.of(texts)
              .map(text -> validatePositiveNumber(text))
              .collect(Collectors.toList());
    }

    public static int validatePositiveNumber(String text) {
        int number = Integer.parseInt(text);
        if(number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
        return number;
    }

}
