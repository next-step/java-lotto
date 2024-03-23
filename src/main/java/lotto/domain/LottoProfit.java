package lotto.domain;

import lotto.domain.type.RewardPrice;

import java.util.*;
import java.util.stream.Collectors;

public class LottoProfit {

  private final LottoTickets lottoTickets;
  private final TreeMap<RewardPrice, Integer> profitMap;

  public LottoProfit(TreeMap<RewardPrice, Integer> profitMap, LottoTickets lottoTickets) {
    this.profitMap = profitMap;
    this.lottoTickets = lottoTickets;
  }

  public static LottoProfit of(WinningNumbers winningNumbers, LottoTickets myLottoTickets) {
    TreeMap<RewardPrice, Integer> profitMap = initRewardPriceMap();
    profitMap.putAll(myLottoTickets.matchedNumberCountBy(winningNumbers));
    return new LottoProfit(profitMap, myLottoTickets);
  }

  public double calculateProfitRate() {
    int profitAmount = 0;
    for (Map.Entry<RewardPrice, Integer> entry : profitMap.entrySet()) {
      profitAmount += entry.getKey().sum(entry.getValue());
    }

    return lottoTickets.calculateProfitRate(profitAmount);
  }

  public TreeMap<RewardPrice, Integer> getProfitMap() {
    profitMap.remove(RewardPrice.NONE);
    return profitMap;
  }

  private static TreeMap<RewardPrice, Integer> initRewardPriceMap() {
    TreeMap<RewardPrice, Integer> profitMap = new TreeMap<>((o1, o2) -> o1.rewardAmount() - o2.rewardAmount());
    List<RewardPrice> filteredInfos = Arrays.stream(RewardPrice.values()).collect(Collectors.toList());
    filteredInfos.forEach(info -> profitMap.put(info, 0));
    return profitMap;
  }
}
