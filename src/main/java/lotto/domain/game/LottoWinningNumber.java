package lotto.domain.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWinningNumber {
  private final List<Integer> numbers;
  private final int bonusNumber;

  public LottoWinningNumber(List<Integer> numbers, int bonusNumber) {
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  public boolean containsWinningNumbers(int number) {
    return this.numbers.contains(number);
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

  public boolean containsDuplicateNumber() {
    final int allNumberCnt = numbers.size() + 1;
    final List<Integer> allNumbers = new ArrayList<>(allNumberCnt);
    allNumbers.addAll(numbers);
    allNumbers.add(bonusNumber);

    long distinctNumberCnt = allNumbers.stream()
        .distinct()
        .count();

    return distinctNumberCnt != allNumberCnt;
  }
}
