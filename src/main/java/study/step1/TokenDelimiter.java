package study.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenDelimiter {

  private final String text;

  private final String PATTERN_EXPRESION = "//(.)\n(.*)";

  private final int DELIMITER = 1;

  private final int MATCHED_TEXT = 2;

  private final String SPLIT_TEXT = ",|:";

  public TokenDelimiter(String text) {
    this.text = text;
  }

  public String[] getNumberTokens() {
    Matcher m = Pattern.compile(PATTERN_EXPRESION).matcher(this.text);

    if (m.find()) {
      String customDelimiter = m.group(DELIMITER);
      return m.group(MATCHED_TEXT).split(customDelimiter);
    }

    return text.split(SPLIT_TEXT);
  }

}
