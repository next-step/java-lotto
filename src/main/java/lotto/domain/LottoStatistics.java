package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.MatchNumbersCount.*;

public class LottoStatistics {
  private final Map<MatchNumbersCount, Integer> statistics;

  public LottoStatistics(List<LottoTicket> lottoTickets, LottoNumbers winningNumbers) {
    this(getStatistics(lottoTickets, winningNumbers));
  }

  public LottoStatistics(Map<MatchNumbersCount, Integer> statistics) {
    this.statistics = statistics;
  }

  private static Map<MatchNumbersCount, Integer> getStatistics(List<LottoTicket> lottoTickets, LottoNumbers winningNumbers) {
    Map<MatchNumbersCount, Integer> statistics = new HashMap<>();
    for (MatchNumbersCount value : values()) {
      statistics.put(value, 0);
    }
    for (LottoTicket lottoTicket : lottoTickets) {
      statistics.put(
          lottoTicket.matchCount(winningNumbers),
          statistics.get(lottoTicket.matchCount(winningNumbers)) + 1
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
}
