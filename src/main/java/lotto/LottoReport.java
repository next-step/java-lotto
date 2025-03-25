package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

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
    return Arrays.stream(LottoPrize.values())
            .filter(prizeCounts::containsKey)
            .sorted(Comparator.comparingInt(LottoPrize::getMatchCount))
            .map(prize -> prize.getPrizeAndCountStatus(prizeCounts.get(prize)))
            .collect(Collectors.joining("\n"));
  }

  public String createMoneyReport() {
    Map<LottoPrize, Integer> prizeCounts = lottos.calculatePrize(winningLotto);
    int totalMoney = prizeCounts.entrySet().stream()
            .map(entry -> entry.getKey().getTotalPrizeMoney(entry.getValue()))
            .reduce(Integer::sum).orElse(0);

    return String.format(TOTAL_PRIZE_RATE, (double) totalMoney / (lottos.getCount() * Lotto.PRICE));
  }
}