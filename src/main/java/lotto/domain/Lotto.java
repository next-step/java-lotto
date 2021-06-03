package lotto.domain;

import lotto.enums.Rank;
import lotto.input.WinningNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Lotto {

  private final List<Integer> numbers;
  private Rank rank;

  public Lotto(NumberGenerator numberGenerator) {
    numbers = numberGenerator.generateNumbers();

    Collections.sort(numbers);
    MessagePrinter.print(Arrays.toString(numbers.toArray()));
  }

  public Rank getRankBy(WinningNumber winningNumber) {
    return Rank.valueOf(
        getMatchCountFrom(winningNumber),
        winningNumber.isMatchBonusNumberWith(this.numbers)
    );
  }

  private int getMatchCountFrom(WinningNumber winningNumber) {
    int count = 0;
    for (int number : winningNumber.getWinningNumbers()) {
      count += numbers.contains(number) ? 1 : 0;
    }

    return count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(numbers, lotto.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }

  public Rank getCalculatedRankBy(WinningNumber winningNumber) {
    setRankBy(winningNumber);

    return getRank();
  }

  private void setRankBy(WinningNumber winningNumber) {
    this.rank = Rank.valueOf(
        getMatchCountFrom(winningNumber),
        winningNumber.isMatchBonusNumberWith(this.numbers)
    );
  }

  private Rank getRank() {
    return this.rank;
  }
}
