package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.model.Rank;

public class LottoGames {
  public static final int LOTTO_PRICE = 1000;

  private List<LottoGame> lottoGames = new ArrayList<>();

  public LottoGames(int purchaseAmount) {
    int autoCount = purchaseAmount / LOTTO_PRICE;

    for (int i = 0; i < autoCount; i++) {
      lottoGames.add(new LottoGame());
    }
  }

  public List<LottoGame> getLottoGames() {
    return lottoGames;
  }

  public WinningResult confirmResult(WinningBalls winningBalls) {
    List<Rank> ranks = lottoGames.stream()
        .map(winningBalls::calculateRank)
        .collect(Collectors.toList());

    return new WinningResult(ranks);
  }
}
