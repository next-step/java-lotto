package lotto.util;

import lotto.domain.Rank;
import lotto.domain.WinLotto;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoStatistics {

  public static WinLotto statistics(List<Rank> ranks) {
    return new WinLotto().getWinLottos(ranks);
  }

  public static double profitRate(int price, WinLotto winLotto) {
    return winLotto.profitRate(price);
  }
}
