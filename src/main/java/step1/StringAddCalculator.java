package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final String DEFAULT_SPLIT_REGEX = ",|:";
  private static final String CUSTOM_SPLIT_REGEX = "//(.)\n(.*)";
  private int result = 0;
  private String inputValue;
  private String[] splitedValue;

  public StringAddCalculator(String value) {
    this.inputValue = value;
  }

  int calculate() {
    return add(this.inputValue);
  }

  public int add(String arg) {
    if (isArgumentInvalid(arg)) {
      return result;
    }
    if (isCustomSplitRegex(arg)) {
      return sumSplitedValue(splitedValue);
    }
    return sumSplitedValue(arg.split(DEFAULT_SPLIT_REGEX));
  }

  private boolean isArgumentInvalid(String arg) {
    return (arg == null || arg.length() == 0);
  }

  private boolean isCustomSplitRegex(String arg) {
    Matcher m = Pattern.compile(CUSTOM_SPLIT_REGEX).matcher(arg);
    if (m.find()) {
      String customDelimiter = m.group(1);
      splitedValue = m.group(2).split(customDelimiter);
      return true;
    }
    return false;
  }

  private int sumSplitedValue(String[] splitedValue) {
    int returnValue = 0;
    for (String val : splitedValue) {
      returnValue += parsedSplitedValue(val);
    }
    return returnValue;
  }

  private int parsedSplitedValue(String arg) {
    int returnValue;
    try {
      returnValue = Integer.parseInt(arg);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException();
    }

    if (returnValue < 0) {
      throw new IllegalArgumentException();
    }
    return returnValue;
  }
}

