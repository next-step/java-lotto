package lotto.domain.round;

import java.util.List;

public class LottoRoundNumbers {

  private final List<Integer> numbers;

  public LottoRoundNumbers (List<Integer> numbers, boolean distinctNumberOnly) {
    throwIfNumbersNotValid(numbers, distinctNumberOnly);
    this.numbers = numbers;
  }

  public LottoRoundNumbers (List<Integer> numbers) {
    throwIfNumbersNotValid(numbers, true);
    this.numbers = numbers;
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

  public List<Integer> getNumbers() {
    return numbers;
  }
}
