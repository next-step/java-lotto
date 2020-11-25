package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.dto.LottoResultDTO;

public class LottoResult {

  private final Map<Rank, Integer> hitHistory;

  public LottoResult() {
    this.hitHistory = new HashMap<>();

    Arrays.stream(Rank.values())
        .forEach(rank -> this.hitHistory.put(rank, 0));
  }

  public int calculateIncome() {
    return Arrays.stream(Rank.values())
        .map(rank -> this.hitHistory.get(rank) * rank.getWinningReward())
        .reduce(0, Integer::sum);
  }

  public void recordHit(Rank rank) {
    this.hitHistory.put(rank, this.hitHistory.get(rank) + 1);
  }

  public LottoResultDTO exportData() {
    return new LottoResultDTO(this.hitHistory);
  }
}
