package stringaddcalculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private final static String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
  public final static Set<String> DEFAULT_SEPARATORS = new HashSet<>(Arrays.asList(",", ":"));

  private StringSeparator stringSeparator;
  private final NumberConverter numberConverter;

  public StringAddCalculator() {
    this.stringSeparator = new StringSeparator(DEFAULT_SEPARATORS);
    this.numberConverter = new DefaultNumberConverter();
  }

  public int sumString(String input) {
    if (StringUtils.isBlank(input)) {
      return 0;
    }
    String calculated = input;
    if (hasCustomDelimiter(input)) {
      setCustomSeparator(input);
      calculated = extractCalculatedStr(input);
    }
    List<String> separateString = this.stringSeparator.separateString(calculated);
    List<Integer> ints = this.numberConverter.convert(separateString);
    return sum(ints);
  }

  private int sum(List<Integer> list) {
    return list.stream()
        .mapToInt(Integer::intValue)
        .sum();
  }


  private boolean hasCustomDelimiter(String calculatedStr) {
    Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(calculatedStr);
    return m.find();
  }

  private void setCustomSeparator(String calculatedStr) {
    Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(calculatedStr);
    if (m.find()) {
      String separator = m.group(1);
      this.stringSeparator = new StringSeparator(separator);
    }
  }

  private String extractCalculatedStr(String calculatedStr) {
    Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(calculatedStr);
    if (m.find()) {
      return m.group(2);
    }
    return calculatedStr;
  }

}
