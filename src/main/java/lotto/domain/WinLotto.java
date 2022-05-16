package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinLotto {

  private final Lotto winLotto;
  private final LottoNumber bonusNumber;

  public WinLotto(List<Integer> lottoNumbers, Integer bonusNumber) {
    this(new Lotto(lottoNumbers), LottoNumber.from(bonusNumber));
  }

  public WinLotto(Lotto winLotto, LottoNumber bonusNumber) {
    if (winLotto.contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 로또 번호와 같을 수 없습니다.");
    }
    this.winLotto = winLotto;
    this.bonusNumber = bonusNumber;
  }

  public Rank match(Lotto lotto) {
    return Rank.of(winLotto.countByMatch(lotto), lotto.contains(bonusNumber));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WinLotto winLotto1 = (WinLotto) o;
    return Objects.equals(winLotto, winLotto1.winLotto) && Objects.equals(
        bonusNumber, winLotto1.bonusNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(winLotto, bonusNumber);
  }
}
