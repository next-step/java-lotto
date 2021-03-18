package string_plus_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class StringPlusCalculator {

  public static final String DEFAULT_DELIMITER = ",|:";

  private String input;

  public StringPlusCalculator(String input) {
    this.input = input;
  }

  public int calculate() {
    if (StringUtils.isBlank(input)) {
      return 0;
    }

    String delimiter = getDelimiter(input);
    String[] numberStrings = input.split(delimiter);
    return sum(numberStrings);
  }

  private String getDelimiter(String input) {
    Matcher m = Pattern.compile("//(.)\r(.*)").matcher(input);
    if (m.find()) {
      this.input = m.group(2);
      return m.group(1);
    }
    return DEFAULT_DELIMITER;
  }

  private int sum(String[] numberStrings) {
    Numbers numbers = new Numbers();
    for (String numberString : numberStrings) {
      numbers.add(Number.from(numberString));
    }
    return numbers.sum();
  }
}
