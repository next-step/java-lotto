package lotto.domain.round;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.number.LottoNumber;

public class LottoRoundNumbers {

  private final List<LottoNumber> numbers;

  public LottoRoundNumbers (List<Integer> numbers) {
    throwIfNumbersNotValid(numbers, true);
    this.numbers = numbers.stream()
        .map(LottoNumber::of)
        .collect(Collectors.toList());
  }

  private void throwIfNumbersNotValid(List<Integer> numbers, boolean distinctNumberOnly) {
    if (!distinctNumberOnly) {
      return;
    }

    long distinctNumberCnt = numbers.stream()
        .distinct()
        .count();

    if (numbers.size() != distinctNumberCnt) {
      throw new IllegalArgumentException();
    }
  }

  public List<LottoNumber> getNumbers () {
    return numbers;
  }
}
