package calculator;

import java.util.List;

public class StringCalculator {

  public static int splitAndSum(String input) {
    List<String> numbers = Separator.split(input);

    return numbers.stream()
        .map(String::trim)
        .map(Integer::valueOf)
        .reduce(0, Integer::sum);
  }
}
