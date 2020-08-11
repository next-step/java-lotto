public class StringCalculator {

  public static int add(String sentence) {
    if (nullOrEmpty(sentence)) return 0;

    String[] values = sentence.split(",|:");
    return Integer.parseInt(values[0]) + Integer.parseInt(values[1]);
  }

  private static boolean nullOrEmpty(String sentence) {
    return sentence == null || sentence.isEmpty();
  }
}
