package util;

import domain.LottoTicket;
import domain.Prize;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class StatisticalCalculator {

  public static Map<Prize, Integer> calculate(List<LottoTicket> lottoTickets,
      List<Integer> winningNumbers) {
    Map<Prize, Integer> prizeCountMap = initializePrizeCountMap();

    for (LottoTicket lottoTicket : lottoTickets) {
      int matchedCount = lottoTicket.getMatchCount(winningNumbers);
      Prize prize = Prize.getPrizeForMatches(matchedCount);
      updateMatchCount(prizeCountMap, prize);
    }

    return prizeCountMap;
  }

  private static void updateMatchCount(Map<Prize, Integer> prizeCountMap, Prize prize) {
    prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
  }

  private static Map<Prize, Integer> initializePrizeCountMap() {
    Map<Prize, Integer> prizeCountMap = new EnumMap<>(Prize.class);
    for (Prize prize : Prize.values()) {
      prizeCountMap.put(prize, 0);
    }
    return prizeCountMap;
  }


  public static int calculateEarnMoney(Map<Prize, Integer> matchedCountMap) {
    int earnMoney = 0;
    for (Prize prize : Prize.values()) {
      earnMoney += addMoney(matchedCountMap, prize);
    }
    return earnMoney;
  }

  private static int addMoney(Map<Prize, Integer> matchedCountMap, Prize prize) {
    return prize.prizeMoney() * matchedCountMap.get(prize);
  }
}
