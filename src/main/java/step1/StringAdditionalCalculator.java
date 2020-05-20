package step1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionalCalculator {

  static int splitAndSum (String text) {
    if (StringUtils.isBlank(text)) return 0;
    String[] numbers = getNumbers(text);
    return Arrays.stream(numbers)
                 .map(StringAdditionalCalculator::validatedNumber)
                 .reduce(0, (sum, a) -> sum + a);
  }

  static String[] getNumbers (String text) {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    return m.find() ? m.group(2).split(m.group(1)) : text.split(",|:");
  }

  static int validatedNumber (String text) {
    try {
      int number = Integer.parseInt(text);
      if (number < 0) throw new Exception();
      return number;
    } catch(Exception e) {
      throw new RuntimeException();
    }
  }

}
