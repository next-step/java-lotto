package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.service.Rank;

public class Lotteries {

  private static final int COUNT = 1;

  private final List<Lotto> lottos;

  public Lotteries(final List<Lotto> lottos) {
    this.lottos = Collections.unmodifiableList(lottos);
  }

  public static Map<Rank, Integer> matchLottosForRank(final Lotteries lotteries, final WinLottoInfo winLottoInfo) {

    Map<Rank, Integer> result = LottoResult.createRankByMap();

    lotteries.lottos.forEach(
        lotto -> result.computeIfPresent(winLottoInfo.getMatchCountForRank(lotto),
            (rank, integer) -> integer + COUNT));
    return result;
  }

  public List<Lotto> toList() {
    return new ArrayList<>(lottos);
  }
}
