package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.service.Rank;

public class Lotteries {

  private static final int COUNT = 1;

  private final List<Lotto> lottos;

  public Lotteries(final List<Lotto> lottos) {
    this.lottos = Collections.unmodifiableList(lottos);
  }

  public static Map<Rank, Integer> matchLottosForRank(final Lotteries lotteries,
      final WinLottoInfo winLottoInfo, final Map<Rank, Integer> result) {
    lotteries.lottos.forEach(
        lotto -> result.computeIfPresent(winLottoInfo.getMatchCountForRank(lotto),
            (rank, integer) -> integer + COUNT));
    return result;
  }

  public static List<String> toStringLottoInfo(final Lotteries lotteries) {
    return lotteries.lottos
        .stream()
        .map(Lotto::toString)
        .collect(Collectors.toList());
  }
}
