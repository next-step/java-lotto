package lotto.domain;

import java.util.Objects;
import lotto.message.Message;
import lotto.service.Rank;

public class WinLottoInfo {

  private static final int INT_ZERO = 0;

  private final Lotto winLotto;

  private final LottoNumber bonusNumber;

  public WinLottoInfo(final Lotto lotto, final int bonus) {
    validation(lotto, bonus);
    this.winLotto = lotto;
    this.bonusNumber = new LottoNumber(bonus);
  }

  private void validation(final Lotto lotto, final int bonus) {
    if(lotto.matchCount(new LottoNumber(bonus)) == 1){
      throw new IllegalArgumentException(Message.MSG_ERROR_DUPLICATE_BONUS);
    }
  }

  public Rank getMatchCountForRank(Lotto lotto) {
    return Rank.matchRank(getCountByRank(lotto),
        isMatchBonus(lotto));
  }

  private int getCountByRank(final Lotto lotto) {
    return winLotto.getLotto().stream()
        .mapToInt(lottoNumber -> checkContainValues(lotto, lottoNumber)).sum();
  }

  private int checkContainValues(final Lotto lotto, final LottoNumber lottoNumber) {
    return lotto.matchCount(lottoNumber);
  }

  private boolean isMatchBonus(final Lotto lotto) {
    return lotto.matchCount(bonusNumber) == 1;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final WinLottoInfo that = (WinLottoInfo) o;
    return Objects.equals(winLotto, that.winLotto) && Objects.equals(bonusNumber,
        that.bonusNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(winLotto, bonusNumber);
  }
}