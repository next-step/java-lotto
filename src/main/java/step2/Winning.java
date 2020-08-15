package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning extends Lotto {

  private int bonusNumber;

  public Winning(String numbersAsString, int bonusNumber) {
    this(
        Arrays.stream(numbersAsString.split(","))
            .map(value -> Integer.parseInt(value.trim()))
            .collect(Collectors.toList()),
        bonusNumber);
  }

  public Winning(List<Integer> numbers, int bonusNumber) {
    super(numbers);
    this.bonusNumber = bonusNumber;
  }

  public int matchCount(Lotto lotto) {
    return numbers.stream().filter(number -> lotto.hasNumber(number)).mapToInt(i -> 1).sum();
  }

  public boolean hasBonusNumber(Lotto lotto) {
    return lotto.hasNumber(bonusNumber);
  }
}
