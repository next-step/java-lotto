package lotto.domain;

import lotto.domain.type.RewardAmount;

import java.util.HashMap;
import java.util.Map;

public class LottoProfit {

  private final LottoTickets lottoTickets;
  private final Map<RewardAmount, Integer> profitMap;

  public LottoProfit(Map<RewardAmount, Integer> profitMap, LottoTickets lottoTickets) {
    this.profitMap = profitMap;
    this.lottoTickets = lottoTickets;
  }

  public static LottoProfit of(WinningNumbers winningNumbers, LottoTickets myLottoTickets) {
    Map<RewardAmount, Integer> profitMap = new HashMap<>();

    for (Map.Entry<Integer, Integer> entry : myLottoTickets.matchNumberCountMap(winningNumbers, myLottoTickets).entrySet()) {
      profitMap.put(RewardAmount.match(entry.getKey()), entry.getValue());
    }

    return new LottoProfit(profitMap, myLottoTickets);
  }

  public double calculateProfitRate() {
    int profitAmount = 0;
    for (Map.Entry<RewardAmount, Integer> entry : profitMap.entrySet()) {
      profitAmount += entry.getKey().sum(entry.getValue());
    }

    return lottoTickets.calculateProfitRate(profitAmount);
  }
}
