import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  public static int add(String sentence) {
    if (nullOrEmpty(sentence)) return 0;

    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(sentence);
    if (matcher.find()) {  // has custom separator
      return add(matcher.group(1), matcher.group(2));
    }

    return add(",|:", sentence);
  }

  private static int add(String regex, String sentence) {
    String[] values = sentence.split(regex);
    if (lengthIsOne(values)) return toInt(sentence);

    return add(values);
  }

  private static Integer add(String[] tokens) {
    return Arrays.stream(tokens)
        .map(v -> toInt(v))
        .reduce((a, b) -> a + b)
        .get();
  }

  private static boolean nullOrEmpty(String sentence) {
    return sentence == null || sentence.isEmpty();
  }

  private static boolean lengthIsOne(String[] values) {
    return values.length == 1;
  }

  private static int toInt(String value) {
    validatorNumber(value);
    return returnIntAfterValidatorNegative(Integer.parseInt(value));
  }

  private static void validatorNumber(String value) {
    for (char ch : value.toCharArray()) {
      if (!Character.isDigit(ch)) throw new RuntimeException();
    }
  }

  private static int returnIntAfterValidatorNegative(int intValue) {
    if (intValue < 0) throw new RuntimeException();
    return intValue;
  }
}
