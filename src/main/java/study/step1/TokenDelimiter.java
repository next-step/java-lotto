package study.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenDelimiter {

  private final String text;

  public TokenDelimiter(String text) {
    this.text = text;
  }

  public String[] getNumberTokens() {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.text);

    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }

    return text.split(",|:");
  }

}
