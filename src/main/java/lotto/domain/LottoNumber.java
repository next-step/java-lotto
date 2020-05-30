package lotto.domain;

import java.util.Random;
import lotto.collections.WinningNumbers;

public class LottoNumber {

  public static final int MINIMUM_NUMBER_BOUND = 1;
  public static final int MAXIMUM_NUMBER_BOUND = 45;

  protected int number;

  public LottoNumber() {
    this.number = getLottoNumberInRange();
  }

  private int getLottoNumberInRange() {
    return new Random().nextInt((MAXIMUM_NUMBER_BOUND - MINIMUM_NUMBER_BOUND) + 1)
        + MINIMUM_NUMBER_BOUND;
  }

  public boolean getMatchCounts(WinningNumbers proposes) {
    return proposes.getWinningNumbers().stream()
        .anyMatch(propose -> propose.getNumber().equals(number));
  }

  public int getNumber() {
    return number;
  }
}
