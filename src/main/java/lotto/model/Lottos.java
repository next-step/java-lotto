package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.strategy.LottoNumberGenerateStrategy;

public class Lottos {

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static Lottos create(int numberOfPurchasedLotto,
      LottoNumberGenerateStrategy numberGenerateStrategy) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < numberOfPurchasedLotto; i++) {
      lottos.add(Lotto.create(numberGenerateStrategy));
    }
    return new Lottos(lottos);
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public int matchLottoRankResult(LottoRank lottoRank, WinningLotto winningLotto) {
    return Math.toIntExact(lottos.stream()
        .map(lotto -> matchLottoRank(winningLotto, lotto))
        .filter(matchRank -> matchRank == lottoRank)
        .count());
  }

  private LottoRank matchLottoRank(WinningLotto winningLotto, Lotto lotto) {
    int matchCountOfLotto = lotto.matchWinningLottoNumbers(winningLotto);
    return LottoRank.findRank(matchCountOfLotto);
  }

  public double calculateProfitRatio(WinningLotto winningLotto) {
    double profitRatio = lottos.stream()
        .map(lotto -> matchLottoRank(winningLotto, lotto))
        .mapToDouble(LottoRank::getReward)
        .sum();

    int purchasedAmount = lottos.size() * Lotto.PRICE_OF_ONE_LOTTO;

    return profitRatio / purchasedAmount;
  }

  @Override
  public String toString() {
    return this.lottos.stream()
        .map(Lotto::toString)
        .collect(Collectors.joining("\n"));
  }
}
