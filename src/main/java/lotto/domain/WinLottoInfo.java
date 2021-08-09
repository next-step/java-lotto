package lotto.domain;

import java.util.List;
import lotto.message.Message;
import lotto.service.Rank;

public class WinLottoInfo {

  private static final int INT_ZERO = 0;

  private Lotto winLotto;

  private LottoNumber bonusNumber;

  private LottoResult lottoResult;

  public WinLottoInfo(final Lotto lotto, final int bonus) {
    validation(lotto, bonus);
    this.winLotto = lotto;
    this.bonusNumber = new LottoNumber(bonus);
  }

  private void validation(final Lotto lotto, final int bonus) {
    if(lotto.getLotto().contains(new LottoNumber(bonus))){
      throw new IllegalArgumentException(Message.MSG_ERROR_DUPLICATE_BONUS);
    }
  }

  public Lotto getWinLotto() {
    return winLotto;
  }

  public LottoNumber getBonusLottoNumber() {
    return bonusNumber;
  }

  public List<LottoNumber> getLottoNumbers(){
    return winLotto.getLotto();
  }

  public LottoResult matchLottoInfo(Lotteries lotteries) {
    return getInputMatchTotalInfo(lotteries);
  }

  public LottoResult getInputMatchTotalInfo(final Lotteries lotteries) {
    lottoResult = new LottoResult();

    for (Lotto lotto : lotteries.getLottos()) {
      getLottosByRank(lotto).add(lotto);
    }

    lottoResult.getCategoriesRank().remove(Rank.MISS);
    return lottoResult;
  }

  private List<Lotto> getLottosByRank(final Lotto lotto) {
    return lottoResult.getMatchLottos(getMatchCountForRank(lotto));
  }

  private Rank getMatchCountForRank(Lotto lotto) {
    return Rank.matchRank(getCountByRank(lotto, INT_ZERO),
        isMatchBonus(lotto));
  }

  private int getCountByRank(final Lotto lotto, int count) {
    for (LottoNumber lottoNumber : winLotto.getLotto()) {
      count = checkContainValues(lotto, count, lottoNumber);
    }

    return count;
  }

  private int checkContainValues(final Lotto lotto, int count, final LottoNumber lottoNumber) {
    if (lotto.match(lottoNumber)) {
      count++;
    }
    return count;
  }

  private boolean isMatchBonus(final Lotto lotto) {
    return lotto.getLotto().contains(bonusNumber);
  }
}