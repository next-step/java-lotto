package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningRank;

public class LottoSet {
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

  public LottoResult calculateResult(Lotto winningLotto) {
    Map<WinningRank, Integer> matchCount = new HashMap<>();

    lottos.stream()
        .map(lotto -> (int) lotto.getNumbers().stream().filter(winningLotto.getNumbers()::contains).count())
        .filter(match -> match >= MINIMUM_MATCH_COUNT)
        .map(WinningRank::fromMatchCount)
        .filter(rank -> rank != null)
        .forEach(rank -> matchCount.put(rank, matchCount.getOrDefault(rank, 0) + 1));

    long totalPrice = matchCount.entrySet().stream()
        .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
        .sum();

    double profitRate = totalPrice == 0 ? 0 : (double) totalPrice / lottoPurchase.getPurchaseAmount();

    return new LottoResult(matchCount, profitRate);
  }

}
