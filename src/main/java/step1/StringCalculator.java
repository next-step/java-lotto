package step1;

public class StringCalculator {

  private Parser<String> parser = new StringParser();

  public int calculate(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }

    final int[] numbers = parser.parse(text);

    return sum(numbers);
  }

  private int sum(int[] numbers) {
    int sum = 0;

    for (int number : numbers) {
      sum += number;
    }

    return sum;
  }

}
