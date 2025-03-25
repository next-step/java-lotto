package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSet implements LottoResultProvider {
  private static final int MINIMUM_MATCH_COUNT = 3;

  private final List<Lotto> lottos;
  private final LottoPurchase lottoPurchase;

  public LottoSet(LottoPurchase lottoPurchase, RandomLottoGenerator lottoGenerator) {
    this.lottoPurchase = lottoPurchase;
    this.lottos = Collections.unmodifiableList(
        IntStream.range(0, lottoPurchase.calculateLottoCount())
            .mapToObj(i -> Lotto.generateRandomLotto(lottoGenerator))
            .collect(Collectors.toList())
    );
  }

  public LottoSet(LottoPurchase lottoPurchase, List<Lotto> lottos) {
    this.lottoPurchase = lottoPurchase;
    this.lottos = Collections.unmodifiableList(lottos);
  }

  public int size() {
    return lottos.size();
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  @Override
  public LottoResult provideLottoResult(Lotto winningLotto) {
    Map<WinningRank, Integer> matchCount = getMatchCount(winningLotto);
    double profitRate = getProfitRate(matchCount);

    return new LottoResult(matchCount, profitRate);
  }

  private Map<WinningRank, Integer> getMatchCount(Lotto winningLotto) {
    Map<WinningRank, Integer> matchCount = new HashMap<>();

    lottos.stream()
        .map(lotto -> (int) lotto.getNumbers().stream().filter(winningLotto.getNumbers()::contains).count())
        .filter(match -> match >= MINIMUM_MATCH_COUNT)
        .map(WinningRank::fromMatchCount)
        .filter(rank -> rank != null)
        .forEach(rank -> matchCount.put(rank, matchCount.getOrDefault(rank, 0) + 1));

    return matchCount;
  }

  private double getProfitRate(Map<WinningRank, Integer> matchCount) {
    long totalPrice = matchCount.entrySet().stream()
        .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
        .sum();

    return totalPrice == 0 ? 0 : (double) totalPrice / lottoPurchase.getPurchaseAmount();
  }
}
