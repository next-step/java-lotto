package StringCalculator;

public class StringCalculator {

  private final String input;

  private StringCalculator(String input) {
    this.input = input;
  }

  public int run() {
    return null;
  }

  public static StringCalculator init(String input) {
    return new StringCalculator(input);
  }
}
