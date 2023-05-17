package lotto;

import java.util.Collections;
import java.util.List;

public class AutoLotto {

  private final List<LottoNo> lotto;

  public AutoLotto(List<LottoNo> lotto) {
    this.lotto = lotto;
    Collections.sort(this.lotto);
  }

  public List<LottoNo> getLotto() {
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
