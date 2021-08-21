package step1;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser implements Parser<String> {

  private static final int CUSTOM_DELIMITER_INDEX = 1;
  private static final int NUMBERS_INDEX = 2;

  public List<NationalNumber> parse(String text) {
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

    if (matcher.find()) {
      final String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
      final String[] numbers = matcher.group(NUMBERS_INDEX).split(customDelimiter);

      return convertToIntArray(numbers);
    }

    return convertToIntArray(text.split("[,:]"));
  }

  private List<NationalNumber> convertToIntArray(String[] numbers) {
    return Arrays.stream(numbers)
        .map(NationalNumber::new)
        .collect(toList());
  }

}
