package step1;

public class StringCalculator {

  private Parser<String> parser = new StringParser();

  public int calculate(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }

    final NationalNumbers numbers = parser.parse(text);

    return numbers.sum();
  }

}
