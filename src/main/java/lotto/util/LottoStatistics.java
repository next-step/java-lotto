package lotto.util;

import lotto.domain.Rank;
import lotto.domain.WinLotto;

import java.util.List;

public class LottoStatistics {

  public static WinLotto statistics(List<Rank> ranks) {
    return new WinLotto().getWinLotto(ranks);
  }

  public static double profitRate(int price, WinLotto winLotto) {
    return winLotto.profitRate(price);
  }
}
