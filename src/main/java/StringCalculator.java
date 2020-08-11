import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  public static int add(String sentence) {
    if (nullOrEmpty(sentence)) return 0;

    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(sentence);
    if (matcher.find()) {
      String customSeparator = matcher.group(1);
      String[] tokens = matcher.group(2).split(customSeparator);
      return Arrays.stream(tokens)
          .map(v -> toInt(v))
          .reduce((a, b) -> a + b)
          .get();
    }

    String[] values = sentence.split(",|:");
    if (lengthIsOne(values)) return toInt(sentence);

    return Arrays.stream(values)
        .map(v -> toInt(v))
        .reduce((a, b) -> a + b)
        .get();
  }

  private static int toInt(String value) {
    return Integer.parseInt(value);
  }

  private static boolean lengthIsOne(String[] values) {
    return values.length == 1;
  }

  private static boolean nullOrEmpty(String sentence) {
    return sentence == null || sentence.isEmpty();
  }
}
