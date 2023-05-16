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
    return lotto.stream().anyMatch(bonusBall::equals);
  }

  public int countMatchesNumber(WinningNumbers winningNumbers) {
    return (int) lotto.stream().filter(winningNumbers::has).count();
  }
}
