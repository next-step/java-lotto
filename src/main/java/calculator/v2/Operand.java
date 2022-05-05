package calculator.v2;

import java.util.regex.Pattern;

public class Operand extends Token {

  private static final String REGEX = "[0-9]+";
  private static final Pattern PATTERN = Pattern.compile(String.format("^(%s)", REGEX));

  public Operand(String input) {
    super(input, PATTERN);
  }

  public static boolean isMatched(String s) {
    return PATTERN.matcher(s).find();
  }

}
