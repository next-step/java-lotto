package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.money.Money;

public class StatisticInfo {

  private final Statistics statistics;
  private final Money purchaseAmount;

  public static StatisticInfo of(WinningLottoTicket winningLottoTicket, LottoTickets lottoTickets,
      Money lottoPrice) {
    validate(winningLottoTicket, lottoTickets, lottoPrice);
    return new StatisticInfo(createStatistics(winningLottoTicket, lottoTickets),
        lottoPrice.multiply(lottoTickets.randomLottoCount()));
  }

  private static Statistics createStatistics(WinningLottoTicket winningLottoTicket,
      LottoTickets lottoTickets) {
    List<Statistic> statistics = Arrays.stream(Prize.values())
        .filter(Prize::winning)
        .map(prize -> new Statistic(lottoTickets.getMatchedCountPerPrize(prize, winningLottoTicket),
            prize))
        .collect(Collectors.toList());
    return new Statistics(statistics);
  }

  private static void validate(WinningLottoTicket winningLottoTicket, LottoTickets lottoTickets,
      Money lottoPrice) {
    if (winningLottoTicket == null) {
      throw new IllegalArgumentException("우승 티켓은 null일 수 없습니다.");
    }
    if (lottoTickets == null) {
      throw new IllegalArgumentException("로또 티켓 그룹은 null일 수 없습니다.");
    }
    if (lottoPrice == null) {
      throw new IllegalArgumentException("로또 가격은 null일 수 없습니다.");
    }
  }

  private StatisticInfo(Statistics statistics, Money purchaseAmount) {
    validate(statistics, purchaseAmount);
    this.statistics = statistics;
    this.purchaseAmount = purchaseAmount;
  }

  private void validate(Statistics statistics, Money purchaseAmount) {
    if (statistics == null) {
      throw new IllegalArgumentException("당첨 통계 그룹은 null일 수 없습니다.");
    }
    if (purchaseAmount == null) {
      throw new IllegalArgumentException("구매금액은 null일 수 없습니다.");
    }
  }

  public List<Statistic> getStatistics() {
    return statistics.getStatistics();
  }

  public double rateOfReturn() {
    Money winAmount = statistics.summingTotalPrizeAmount();
    Rate divide = Rate.of((double) winAmount.value() / purchaseAmount.value());
    return divide.getRate();
  }
}
