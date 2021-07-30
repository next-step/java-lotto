package stringCalculator;

import java.util.Arrays;

public class StringCalculator {

  private String text;

  public static final String SPLIT_MARK = ",|:";

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

  public String[] getSplitValues() {
    return text.split(SPLIT_MARK);
  }

  public int getSumValues() {
    return Arrays.stream(getSplitValues()).mapToInt(this::toInt).sum();
  }

  private int toInt(String s) {
    return Integer.parseInt(s);
  }
}
