package lotto;

import java.util.Map;

public class LottoReport {

  private static final String TOTAL_PRIZE_RATE = "총 수익률은 %.2f입니다.";
  private final Lotto winningLotto;
  private final Lottos lottos;

  public LottoReport(Lotto winningLotto, Lottos lottos) {
    this.winningLotto = winningLotto;
    this.lottos = lottos;
  }

  public String createCountReport() {
    Map<LottoPrize, Integer> prizeCounts = lottos.calculatePrize(winningLotto);
    return prizeCounts.entrySet().stream()
            .map(entry -> entry.getKey().getPrizeAndCountStatus(entry.getValue()))
            .reduce((a, b) -> a + "\n" + b)
            .orElse("");
  }

  public String createMoneyReport() {
    Map<LottoPrize, Integer> prizeCounts = lottos.calculatePrize(winningLotto);
    int totalMoney = prizeCounts.entrySet().stream()
            .map(entry -> entry.getKey().getTotalPrizeMoney(entry.getValue()))
            .reduce(Integer::sum).orElse(0);

    return String.format(TOTAL_PRIZE_RATE, (double) totalMoney / (lottos.getCount() * Lotto.PRICE));
  }
}