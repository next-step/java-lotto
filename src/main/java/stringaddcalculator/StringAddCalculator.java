package stringaddcalculator;

import java.util.List;

public class StringAddCalculator {

  public static Integer sum(List<PositiveNumber> positiveNumbers) {
    return positiveNumbers.stream()
        .mapToInt(PositiveNumber::getNumber)
        .sum();
  }
}
