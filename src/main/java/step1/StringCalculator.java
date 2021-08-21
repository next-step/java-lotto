package step1;

import java.util.List;

public class StringCalculator {

  private Parser<String> parser = new StringParser();

  public int calculate(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }

    final List<NationalNumber> numbers = parser.parse(text);

    return sum(numbers);
  }

  private int sum(List<NationalNumber> numbers) {
    int sum = 0;

    for (NationalNumber number : numbers) {
      sum += number.getNumber();
    }

    return sum;
  }

}
