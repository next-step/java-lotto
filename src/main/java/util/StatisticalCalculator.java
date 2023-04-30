package util;

import domain.LottoTicket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticalCalculator {

  public static Map<Integer, Integer> calculate(List<LottoTicket> lottoTickets,
      List<Integer> winningNumbers) {
    int matched3Count = 0;
    int matched4Count = 0;
    int matched5Count = 0;
    int matched6Count = 0;

    for (LottoTicket lottoTicket : lottoTickets) {
      int matchedCount = lottoTicket.matchCount(winningNumbers);

      if (matchedCount == 3) {
        matched3Count++;
      }
      if (matchedCount == 4) {
        matched4Count++;
      }
      if (matchedCount == 5) {
        matched5Count++;
      }
      if (matchedCount == 6) {
        matched6Count++;
      }
    }

    Map<Integer, Integer> matchedCountMap = new HashMap<>();
    matchedCountMap.put(3, matched3Count);
    matchedCountMap.put(4, matched4Count);
    matchedCountMap.put(5, matched5Count);
    matchedCountMap.put(6, matched6Count);

    return matchedCountMap;
  }

  public static int calculateEarnMoney(Map<Integer, Integer> matchedCountMap) {
    int earnMoney = 0;
    for (Integer key : matchedCountMap.keySet()) {
      earnMoney += LottoTicket.calculatePrize(key) * matchedCountMap.get(key);
    }
    return earnMoney;
  }
}
