package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {

  private List<Number> numbers;

  public Numbers(String text) {
    this.numbers = createNumbers(text);
  }

  public List<Number> createNumbers(String text) {
    return Arrays.stream(splitString(text)).map(Number::new).collect(Collectors.toList());
  }

  public int sumOfNumbers() {
    return numbers.stream().mapToInt(Number::getNumber).sum();
  }

  private String[] splitString(String text) {
    Matcher m = Pattern.compile(Constant.CUSTOM_SPLIT_REGEX_PATTERN).matcher(text);
    if (m.find()) {
      String customDelimiter = m.group(Constant.DELIMITER_LOCATION);
      return m.group(Constant.NUMBERS_LOCATION).split(customDelimiter);
    }
    return text.split(Constant.BASIC_SPLIT_REGEX);
  }
}
