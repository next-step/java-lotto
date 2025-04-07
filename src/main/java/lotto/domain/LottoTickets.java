package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

  private static final int PRICE_PER_LOTTO = 1000;

  private final List<Lotto> lottoTickets;

  public LottoTickets(int numberLottos) {
    lottoTickets = new ArrayList<>();
    for (int i = 0; i < numberLottos; i++) {
      lottoTickets.add(new Lotto());
    }
  }

  public static LottoTickets of(int price) {
    return new LottoTickets(price / PRICE_PER_LOTTO);
  }

  public int size() {
    return lottoTickets.size();
  }

  public Map<PrizeRank, Integer> calculateWinningStatistics(Lotto winningNumbers, int bonusBall) {
    Map<PrizeRank, Integer> statistics = new HashMap<>();
    for (PrizeRank rank : PrizeRank.values()) {
      statistics.put(rank, 0);
    }

    for (Lotto ticket : lottoTickets) {
      updateStatisticsForTicket(winningNumbers, bonusBall, ticket, statistics);
    }
    return statistics;
  }

  private void updateStatisticsForTicket(Lotto winningNumbers, int bonusBall, Lotto ticket,
      Map<PrizeRank, Integer> statistics) {
    PrizeRank rank = PrizeRank.valueOf(ticket.countMatchingNumbers(winningNumbers), ticket.hasBonusBall(bonusBall));
    if (rank != null) {
      statistics.merge(rank, 1, Integer::sum);
    }
  }

  public double calculateProfitRate(Map<PrizeRank, Integer> statistics) {
    int totalPrize = statistics.entrySet().stream()
        .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
        .sum();

    int totalCost = lottoTickets.size() * PRICE_PER_LOTTO;
    return (double) totalPrize / totalCost;
  }

  public List<String> getLottoNumbersAsStrings() {
    return lottoTickets.stream()
        .map(Lotto::toString)
        .collect(Collectors.toList());
  }
}
