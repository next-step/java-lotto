import java.util.Arrays;

public class StringCalculator {

  public static int add(String sentence) {
    if (nullOrEmpty(sentence)) return 0;

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
