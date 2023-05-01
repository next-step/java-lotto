package lotto2.util;

import lotto2.domain.LottoTicket;
import lotto2.domain.Prize;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatisticalCalculator {

  public static Map<Prize, Long> calculate(List<LottoTicket> lottoTickets,
      List<Integer> winningNumbers) {
    List<Prize> prizes = new ArrayList<>();
    for(LottoTicket lottoTicket : lottoTickets) {
      int matchedCount = lottoTicket.findMatchingCount(winningNumbers);
      Prize prize = Prize.valueOf(matchedCount);
      prizes.add(prize);
    }
    return Prize.groupPrizesAndCount(prizes);
  }



  public static long calculateEarnMoney(Map<Prize, Long> matchedCountMap) {
    long earnMoney = 0;
    for (Prize prize : Prize.values()) {
      earnMoney += addMoney(matchedCountMap, prize);
    }
    return earnMoney;
  }

  private static long addMoney(Map<Prize, Long> matchedCountMap, Prize prize) {
    return prize.prizeMoney() * matchedCountMap.getOrDefault(prize, 0L);
  }
}
