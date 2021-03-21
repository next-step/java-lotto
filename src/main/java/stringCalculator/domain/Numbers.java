package stringCalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

  private List<Number> numbers = new ArrayList<>();

  public Numbers(String[] numberStrings) {
    for (String numberString : numberStrings) {
      numbers.add(new Number(numberString));
    }
  }

  public int sum() {
    return numbers.stream()
        .mapToInt(Number::getNumber)
        .sum();
  }
}
