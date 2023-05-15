package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

  private final List<Integer> lotto;

  public Lotto(List<Integer> lotto) {
    this.lotto = lotto;
    Collections.sort(this.lotto);
  }

  public List<Integer> getLotto() {
    return lotto;
  }

  @Override
  public String toString() {
    return lotto.toString();
  }

  public boolean has(BonusBall bonusBall) {
    boolean has = false;
    for (Integer number: lotto) {
      has = bonusBall.equals(number) || has;
    }
    return has;
  }

  public int countMatchesNumber(WinningNumbers winningNumbers) {
    int count = 0;
    for (Integer number: lotto) {
      count += winningNumbers.has(number) ? 1 : 0;
    }
    return count;
  }
}
