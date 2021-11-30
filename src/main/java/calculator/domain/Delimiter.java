package calculator.domain;

import java.util.regex.Pattern;

public class Delimiter {

  private static final Pattern DEFAULT_DELIMITER = Pattern.compile("[:,]");

  private final Pattern delimiterPattern;

  private Delimiter() {
    this(DEFAULT_DELIMITER);
  }

  private Delimiter(Pattern delimiterPattern) {
    this.delimiterPattern = delimiterPattern;
  }

  public static Delimiter from(String delimiterRegex) {
    if (delimiterRegex == null) {
      return new Delimiter();
    }
    return new Delimiter(Pattern.compile(delimiterRegex, Pattern.LITERAL));
  }

  public String[] split(String target) {
    return delimiterPattern.split(target);
  }
}
