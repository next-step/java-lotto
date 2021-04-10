package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoRanks {

  private final List<LottoRank> lottoRanks;

  public LottoRanks(List<LottoRank> lottoRanks) {
    this.lottoRanks = lottoRanks;
  }

  public Map<LottoRank, Long> getMatchResult() {
    return lottoRanks.stream()
        .filter(LottoRank::isNotNone)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public Long toStringMatchCount(LottoRank lottoRank) {
    return lottoRanks.stream()
        .filter(LottoRank::isNotNone)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .getOrDefault(lottoRank,0L);
  }
}
