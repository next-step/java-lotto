package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static lotto.domain.MatchNumbersCount.*;

public class LottoStatistics {
  private final Map<MatchNumbersCount, Integer> statistics;

  public LottoStatistics(
      LottoTickets lottoTickets,
      LottoNumbers winningNumbers,
      LottoNumber bonusNumber
  ) {
    this(getStatistics(lottoTickets, winningNumbers, bonusNumber));
  }

  public LottoStatistics(Map<MatchNumbersCount, Integer> statistics) {
    this.statistics = statistics;
  }

  private static Map<MatchNumbersCount, Integer> getStatistics(
      LottoTickets lottoTickets,
      LottoNumbers winningNumbers,
      LottoNumber bonusNumber
  ) {
    Map<MatchNumbersCount, Integer> statistics = new HashMap<>();
    for (MatchNumbersCount value : values()) {
      statistics.put(value, 0);
    }
    for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
      statistics.put(
          lottoTicket.matchCount(winningNumbers, bonusNumber),
          statistics.get(lottoTicket.matchCount(winningNumbers, bonusNumber)) + 1
      );
    }
    return statistics;
  }

  public Map<MatchNumbersCount, Integer> getStatistics() {
    return statistics;
  }

  public float getRateOfReturn() {
    long totalPrize = getTotalPrize();
    int ticketCount = getTicketCount();
    return (float) Math.round(((float) totalPrize / (ticketCount * LottoTicket.TICKET_PRICE) * 100)) / 100;
  }

  private long getTotalPrize() {
    return statistics.entrySet().stream()
                     .mapToLong(entry -> (long) entry.getKey().getPrize().getAmount() * entry.getValue())
                     .sum();
  }

  private int getTicketCount() {
    return statistics.values().stream()
                     .mapToInt(i -> i)
                     .sum();
  }

  @Override
  public String toString() {
    return "LottoStatistics{" +
           "statistics=" + statistics +
           '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoStatistics that = (LottoStatistics) o;
    return Objects.equals(statistics, that.statistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statistics);
  }
}
