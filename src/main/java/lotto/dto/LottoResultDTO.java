package lotto.dto;

import java.util.Map;
import lotto.Rank;

public class LottoResultDTO {

  private final Map<Rank, Integer> hitHistory;

  public LottoResultDTO(Map<Rank, Integer> hitHistory) {
    this.hitHistory = hitHistory;
  }

  public Map<Rank, Integer> getHitHistory() {
    return hitHistory;
  }
}
