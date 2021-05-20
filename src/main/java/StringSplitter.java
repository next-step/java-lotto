import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

  private String delimiterRegex;
  private final String customDelimiterRegex;

  public StringSplitter(String delimiterRegex, String customDelimiterRegex) {
    this.delimiterRegex = delimiterRegex;
    this.customDelimiterRegex = customDelimiterRegex;
  }

  public String[] split(String text) {
    Matcher m = Pattern.compile(customDelimiterRegex).matcher(text);
    if (m.find()) {
      delimiterRegex = m.group(1);
      text = m.group(2);
    }

    return text.split(delimiterRegex);
  }
}
