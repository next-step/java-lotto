package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning extends Lotto {

  public Winning(String numbersAsString) {
    this(
        Arrays.stream(numbersAsString.split(","))
            .map(value -> Integer.parseInt(value.trim()))
            .collect(Collectors.toList()));
  }

  public Winning(List<Integer> numbers) {
    super(numbers);
  }

  public int sameNumberCount(Lotto lotto) {
    return numbers.stream().filter(number -> lotto.hasNumber(number)).mapToInt(i -> 1).sum();
  }
}
