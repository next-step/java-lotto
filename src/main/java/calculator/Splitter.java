package calculator;

import java.util.Arrays;
import java.util.List;

public class Splitter {

  private static final String DEFAULT_SPLIITER = " ";
  private static final String EXCEPTION_MESSAGE = "나누려는 문자열을 입력하세요";

  private Splitter() {
  }

  public static List<String> split(String s) {
    if (s == null || s.isBlank()) {
      throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    return Arrays.asList(s.split(DEFAULT_SPLIITER));
  }
}
