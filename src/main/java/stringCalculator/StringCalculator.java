package stringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  private String text;

  public static final String CUSTOM_PATTEN = "//(.)\n(.*)";

  public static final String SPLIT_MARK = "[,:]";

  public static final String DEFAULT_VALUE = "0";

  public StringCalculator(String inputText) {
    this.text = validationText(inputText);
  }

  private String validationText(String text) {
    if(text == null || text.isEmpty()){
      return DEFAULT_VALUE;
    }
    return text;
  }

  public String getText() {
    return text;
  }

  public String[] getSplitValues(String pattern) {
    if(pattern.equals(SPLIT_MARK)){
      return text.split(SPLIT_MARK);
    }
    return getText().split(pattern);
  }

  public int getSumValues(String[] values) {
    return Arrays.stream(values).mapToInt(this::toInt).sum();
  }

  private int toInt(String s) {
    return Integer.parseInt(s);
  }

  public int getCustomSplitSum() {
    Matcher m = Pattern.compile(CUSTOM_PATTEN).matcher(getText());

    if (m.find()) {
      String customDelimiter = m.group(1);
      text = m.group(2);
      return getSumValues(getSplitValues(customDelimiter));
    }
    return getSumValues(getSplitValues(SPLIT_MARK));
  }
}
