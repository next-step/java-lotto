package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
  public LottoResult provideLottoResult(WinningLotto winningLottoWithBonus) {
    Map<WinningRank, Integer> matchCount = getMatchCount(winningLottoWithBonus);
    double profitRate = getProfitRate(matchCount);

    return new LottoResult(matchCount, profitRate);
  }

  private Map<WinningRank, Integer> getMatchCount(WinningLotto winningLottoWithBonus) {
    return lottos.stream()
        .map(lotto -> calculateMatchRank(lotto, winningLottoWithBonus))
        .filter(Objects::nonNull)
        .collect(Collectors.toMap(
            rank -> rank,
            rank -> 1,
            Integer::sum
        ));
  }

  private WinningRank calculateMatchRank(Lotto lotto, WinningLotto winningLottoWithBonus) {
    return winningLottoWithBonus.calculateRank(lotto);
  }

  private double getProfitRate(Map<WinningRank, Integer> matchCount) {
    long totalPrice = matchCount.entrySet().stream()
        .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
        .sum();

    return lottoPurchase.calculateProfitRate(totalPrice);
  }
}
