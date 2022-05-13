package calculator;

import java.util.Arrays;
import java.util.List;

public class Splitter {

  private static final String DEFAULT_SPLIITER = " ";
  private static final String EMPTY_INPUT_STRING = "나누려는 문자열을 입력하세요";
  private static final String EMPTY_DELIMITER = "구분자를 입력하세요";

  private Splitter() {
  }

  public static List<String> split(String s) {
    if (s == null || s.isBlank()) {
      throw new IllegalArgumentException(EMPTY_INPUT_STRING);
    }

    return Arrays.asList(s.split(DEFAULT_SPLIITER));
  }

  public static List<String> split(String s, String delimiter) {
    if (s == null || s.isBlank()) {
      throw new IllegalArgumentException(EMPTY_INPUT_STRING);
    }

    if (delimiter == null || delimiter.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_DELIMITER);
    }

    return Arrays.asList(s.split(delimiter));
  }
}
