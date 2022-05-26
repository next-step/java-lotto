package calculator;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Splitter {

  private static final String DEFAULT_SPLIITER = " ";
  private static final String EMPTY_INPUT_STRING = "나누려는 문자열을 입력하세요";
  private static final String EMPTY_DELIMITER = "구분자를 입력하세요";
  private static final String WHITESPACE_REGEX = "\\s+";

  private Splitter() {
  }

  public static List<String> split(String s) {
    System.out.println("s = " + s);
    validateString(s);

    return Arrays.asList(s.split(DEFAULT_SPLIITER));
  }

  public static List<String> split(String s, String delimiter) {
    validateString(s);
    validateDelimiter(delimiter);

    return Arrays.asList(s.split(delimiter));
  }

  public static List<Integer> splitAsList(String s, String delimiter) {
    validateString(s);
    validateDelimiter(delimiter);

    return Splitter.split(s, delimiter)
        .stream()
        .map(Splitter::removeWhitespace)
        .map(Integer::parseInt)
        .collect(toList());
  }

  private static String removeWhitespace(String s) {
    return s.replaceAll(WHITESPACE_REGEX, "");
  }

  private static void validateDelimiter(String delimiter) {
    if (delimiter == null || delimiter.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_DELIMITER);
    }
  }

  private static void validateString(String s) {
    if (s == null || s.isBlank()) {
      throw new IllegalArgumentException(EMPTY_INPUT_STRING);
    }
  }

}
