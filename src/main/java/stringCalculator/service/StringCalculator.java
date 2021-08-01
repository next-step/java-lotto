package stringCalculator.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import stringCalculator.domain.StringValue;
import stringCalculator.message.Message;

public class StringCalculator {

  private StringValue stringValue;

  public static final String NUMBER_FORMAT_PATTEN = "^[0-9]*$";

  public static final String CUSTOM_PATTEN = "//(.)\\n(.*)";

  public static final String SPLIT_MARK = "[,:]";

  public StringCalculator(String inputText) {
    stringValue = new StringValue(inputText);
  }

  public String getStringValue() {
    return stringValue.getStringValue();
  }

  public String[] getSplitValues(String pattern) {
    return stringValue.getSplit(pattern);
  }

  public int getSumValues(String[] values) {
    return Arrays.stream(values).mapToInt(s -> toInt(checkNumberFormat(s))).sum();
  }

  private int toInt(String s) {
    return Integer.parseInt(s);
  }

  public int getCustomSplitSum() {

    Matcher m = Pattern.compile(CUSTOM_PATTEN).matcher(getStringValue());

    if (m.find()) {
      String customDelimiter = m.group(1);
      stringValue = new StringValue(m.group(2));
      return getSumValues(getSplitValues(customDelimiter));
    }

    return getSumValues(getSplitValues(SPLIT_MARK));
  }

  public String checkNumberFormat(String text) {
    Pattern pattern = Pattern.compile(NUMBER_FORMAT_PATTEN);
    Matcher matcher = pattern.matcher(text);
    if(!matcher.matches()){
      throw new RuntimeException(Message.MSG_ERROR_NUMBER_TYPE);
    }
    return text;
  }
}
