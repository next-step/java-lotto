package lotto.domain;

import java.util.List;
import lotto.domain.model.Rank;

public class WinningResult {

  private List<Rank> ranks;

  WinningResult(List<Rank> ranks) {
    this.ranks = ranks;
  }

  public List<Rank> getRanks() {
    return ranks;
  }
}
