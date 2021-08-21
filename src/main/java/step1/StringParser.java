package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser implements Parser<String> {

  private static final int CUSTOM_DELIMITER_INDEX = 1;
  private static final int NUMBERS_INDEX = 2;

  public NationalNumbers parse(String text) {
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

    if (!matcher.find()) {
      return convertTo(text.split("[,:]"));
    }

    final String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
    final String[] numbers = matcher.group(NUMBERS_INDEX).split(customDelimiter);

    return convertTo(numbers);
  }

  private NationalNumbers convertTo(String[] numbers) {
    return new NationalNumbers(numbers);
  }

}
