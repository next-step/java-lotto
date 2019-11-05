package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final String DEFAULT_SPLIT_REGEX = ",|:";
  private static final String CUSTOM_SPLIT_REGEX = "//(.)\n(.*)";
  private static final int CUSTOM_DELIMITER_SPLIT_GROUP = 1;
  private static final int CUSTOM_DELIMITER_SPLIT_VALUE = 2;
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
      return sumSplitedArr(splitedValue);
    }
    return sumSplitedArr(arg.split(DEFAULT_SPLIT_REGEX));
  }

  private boolean isArgumentInvalid(String arg) {
    return (arg == null || arg.length() == 0);
  }

  private boolean isCustomSplitRegex(String arg) {
    Matcher m = Pattern.compile(CUSTOM_SPLIT_REGEX).matcher(arg);
    if (m.find()) {
      String customDelimiter = m.group(CUSTOM_DELIMITER_SPLIT_GROUP);
      splitedValue = m.group(CUSTOM_DELIMITER_SPLIT_VALUE).split(customDelimiter);
      return true;
    }
    return false;
  }

  private int sumSplitedArr(String[] splitedArr) {
    int returnValue = 0;
    for (String val : splitedArr) {
      returnValue += parsedSplitedValue(val);
    }
    return returnValue;
  }

  private int parsedSplitedValue(String arg) {
    int returnValue;
    try {
      returnValue = Integer.parseInt(arg);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("숫자형 변환에 실패하였습니다.");
    }

    if (returnValue < 0) {
      throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
    }
    return returnValue;
  }
}

