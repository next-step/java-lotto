package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.strategy.LottoNumberGenerateStrategy;

public class Lottos {

  private static final String LOTTOS_NULL_OR_EMPTY_ERROR_MESSAGE = "로또 묶음이 Null 또는 Empty입니다.";

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    validate(lottos);
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

  private void validate(List<Lotto> lottos) {
    if(lottos == null || lottos.isEmpty()) {
      throw new IllegalArgumentException(LOTTOS_NULL_OR_EMPTY_ERROR_MESSAGE);
    }
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
    int matchCountOfLotto = winningLotto.matchWinningLottoNumbers(lotto);
    boolean matchBonusLottoNumber = winningLotto.isWinningBonusLottoNumber(lotto);
    return LottoRank.findRank(matchCountOfLotto, matchBonusLottoNumber);
  }

  public double calculateProfitRatio(WinningLotto winningLotto) {
    return calculateTotalRewardAmountByRanking(winningLotto) / calculatePurchasedAmount();
  }

  private double calculateTotalRewardAmountByRanking(WinningLotto winningLotto) {
    return lottos.stream()
        .map(lotto -> matchLottoRank(winningLotto, lotto))
        .mapToDouble(LottoRank::getReward)
        .sum();
  }

  private int calculatePurchasedAmount() {
    return lottos.size() * Lotto.PRICE_OF_ONE_LOTTO;
  }

  @Override
  public String toString() {
    return this.lottos.stream()
        .map(Lotto::toString)
        .collect(Collectors.joining("\n"));
  }
}
