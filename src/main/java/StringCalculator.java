public class StringCalculator {

  public static int add(String sentence) {
    if (nullOrEmpty(sentence)) return 0;

    String[] values = sentence.split(",|:");
    if (lengthIsOne(values)) return toInt(sentence);

    int result = toInt(values[0]);
    for (int i = 1; i < values.length; i++) {
      result += toInt(values[i]);
    }

    return result;
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
