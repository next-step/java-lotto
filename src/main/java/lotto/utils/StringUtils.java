package lotto.utils;

import java.util.regex.Pattern;

public class StringUtils {

  private static final String EMPTY_STRING = "";
  private static final Pattern SPACE = Pattern.compile("\\s");
  private static final Pattern COMMA = Pattern.compile(",");

  public static String[] splitByComa(String input) {
    return COMMA.split(SPACE.matcher(input).replaceAll(EMPTY_STRING));
  }

  private StringUtils() {}
}
