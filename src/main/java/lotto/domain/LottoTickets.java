package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

  private static final int PRICE_PER_LOTTO = 1000;
  private static final Map<Integer, Integer> PRIZE_TABLE = new HashMap<>();

  static {
    PRIZE_TABLE.put(3, 5000);
    PRIZE_TABLE.put(4, 50000);
    PRIZE_TABLE.put(5, 1500000);
    PRIZE_TABLE.put(6, 2000000000);
  }

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

  public Map<Integer, Integer> calculateWinningStatistics(Lotto winningNumbers) {
    Map<Integer, Integer> statistics = new HashMap<>();
    for (int i = 3; i <= 6; i++) {
      statistics.put(i, 0);
    }

    for (Lotto ticket : lottoTickets) {
      int matchCount = ticket.countMatchingNumbers(winningNumbers);
      if (matchCount >= 3) {
        statistics.merge(matchCount, 1, Integer::sum);
      }
    }
    return statistics;
  }

  public double calculateProfitRate(Map<Integer, Integer> statistics) {
    int totalPrize = statistics.entrySet().stream()
        .mapToInt(entry -> entry.getValue() * PRIZE_TABLE.get(entry.getKey()))
        .sum();
    return (double) totalPrize / (lottoTickets.size() * PRICE_PER_LOTTO);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Lotto lotto : lottoTickets) {
      sb.append(lotto.toString()).append("\n");
    }
    return sb.toString();
  }
}
