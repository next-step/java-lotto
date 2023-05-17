package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

  private final List<LottoNo> lotto;

  public Lotto(List<LottoNo> lotto) {
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
    return lotto.stream().anyMatch(lottoNo -> lottoNo.has(bonusBall));
  }

  public int countMatchesNumber(WinningNumbers winningNumbers) {
    return (int) lotto.stream().filter(lottoNo -> lottoNo.has(winningNumbers)).count();
  }
}
