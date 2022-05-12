package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.money.Money;

public class StatisticInfo {

  private final Statistics statistics;
  private final Money purchaseAmount;

  public StatisticInfo(WinningLottoTicket winningLottoTicket, LottoTickets lottoTickets,
      Money lottoPrice) {
    validateWinningLottoTicket(winningLottoTicket);
    validateLottoTickets(lottoTickets);

    this.statistics = createStatistics(winningLottoTicket, lottoTickets);
    this.purchaseAmount = lottoPrice.multiply(lottoTickets.size());
  }

  public List<Statistic> getStatistics() {
    return statistics.getStatistics();
  }

  public double rateOfReturn() {
    Money winAmount = statistics.summingTotalPrizeAmount();
    Rate divide = Rate.of((double) winAmount.value() / purchaseAmount.value());
    return divide.getRate();
  }

  private void validateLottoTickets(LottoTickets lottoTickets) {
    if (lottoTickets == null) {
      throw new IllegalArgumentException("로또 그룹은 null 일 수 없습니다.");
    }
  }

  private void validateWinningLottoTicket(WinningLottoTicket winningLottoTicket) {
    if (winningLottoTicket == null) {
      throw new IllegalArgumentException("우승 티켓은 null 일 수 없습니다.");
    }
  }

  private Statistics createStatistics(WinningLottoTicket winningLottoTicket,
      LottoTickets lottoTickets) {
    List<Statistic> statistics = Arrays.stream(Prize.values())
        .filter(prize -> prize != Prize.NOT_PRIZE)
        .map(prize -> new Statistic(lottoTickets.getMatchedCountPerPrize(prize, winningLottoTicket),
            prize))
        .collect(Collectors.toList());
    return new Statistics(statistics);
  }
}
