package lotto.domain.result;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoSet;

public class LottoResultAnalyzer {

  public LottoResult analyze(LottoSet lottoSet, Lotto winningLotto) {
    Map<WinningRank, Integer> matchCount = calculateMatchCount(lottoSet, winningLotto);
    double profitRate = calculateProfitRate(lottoSet.totalPrice(), matchCount);

    LottoResult lottoResult = new LottoResult();
    lottoResult.setMatchCount(matchCount);
    lottoResult.setProfitRate(profitRate);
    return lottoResult;
  }

  private Map<WinningRank, Integer> calculateMatchCount(LottoSet lottoSet, Lotto winningLotto) {
    Map<WinningRank, Integer> matchCount = new HashMap<>();

    lottoSet.getLottos().stream()
        .map(lotto -> (int) lotto.getNumbers().stream().filter(winningLotto.getNumbers()::contains).count())
        .filter(match -> match >= 3)
        .map(WinningRank::fromMatchCount)
        .filter(rank -> rank != null)
        .forEach(rank -> matchCount.put(rank, matchCount.getOrDefault(rank, 0) + 1));

    return matchCount;
  }

  private double calculateProfitRate(int cost, Map<WinningRank, Integer> matchCount) {
    long totalPrice = matchCount.entrySet().stream()
        .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
        .sum();

    return totalPrice == 0 ? 0 : (double) totalPrice / cost;
  }
}
