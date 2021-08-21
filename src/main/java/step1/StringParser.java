package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser implements Parser<String> {

  private static final int CUSTOM_DELIMITER_INDEX = 1;
  private static final int NUMBERS_INDEX = 2;

  public int[] parse(String text) {
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

    if (matcher.find()) {
      final String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
      final String[] numbers = matcher.group(NUMBERS_INDEX).split(customDelimiter);

      return convertToIntArray(numbers);
    }

    return convertToIntArray(text.split("[,:]"));
  }

  private int[] convertToIntArray(String[] numbers) {
    return Arrays.stream(numbers)
        .mapToInt(number -> {
          validate(number);
          return Integer.parseInt(number);
        })
        .toArray();
  }

  private void validate(String number) {
    if (isNumberAndIsNotNegative(number)) {
      throw new IllegalArgumentException("숫자 이외의 값 또는 음수를 입력할 수 없다");
    }
  }

  private boolean isNumberAndIsNotNegative(String number) {
    return number.chars().allMatch(Character::isDefined) && Integer.parseInt(number) < 0;
  }
}
