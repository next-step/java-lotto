package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.model.Rank;

public class LottoGames {
  public static final int LOTTO_PRICE = 1_000;

  private List<LottoGame> lottoGames;

  public LottoGames(int purchaseAmount, List<LottoGame> manualLottoGames) {
    int autoCount = calculateAutoCount(purchaseAmount, manualLottoGames.size());

    this.lottoGames = Stream.concat(
        manualLottoGames.stream(),
        Stream.generate(LottoGame::new).limit(autoCount)
    ).collect(Collectors.toList());
  }

  private int calculateAutoCount(int purchaseAmount, int manualCount) {
    int lottoCount = purchaseAmount / LOTTO_PRICE;

    if (lottoCount < manualCount) {
      throw new IllegalArgumentException("수동으로 입력한 로또의 수가 구매 금액으로 살 수 있는 로또의 수보다 큽니다.");
    }

    return lottoCount - manualCount;
  }

  public List<LottoGame> getLottoGames() {
    return Collections.unmodifiableList(lottoGames);
  }

  public WinningResult confirmResult(WinningLottoGame winningLottoGame) {
    List<Rank> ranks = lottoGames.stream()
        .map(winningLottoGame::calculateRank)
        .collect(Collectors.toList());

    return new WinningResult(ranks);
  }
}
