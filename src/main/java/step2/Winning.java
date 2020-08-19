package step2;

import java.util.List;
import java.util.stream.StreamSupport;

public class Winning {

  private final Lotto lotto;
  private int bonusNumber;

  public Winning(String numbersAsString, int bonusNumber) {
    this(LottosGenerator.list(numbersAsString), bonusNumber);
  }

  public Winning(List<Integer> numbers, int bonusNumber) {
    this.lotto = new Lotto(numbers);
    this.bonusNumber = bonusNumber;
  }

  public int matchCount(Lotto lotto) {
    return StreamSupport.stream(this.lotto.spliterator(), false)
        .filter(lotto::hasNumber)
        .mapToInt(i -> 1)
        .sum();
  }

  public boolean hasBonusNumber(Lotto lotto) {
    return lotto.hasNumber(bonusNumber);
  }
}
