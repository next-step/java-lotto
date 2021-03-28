package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoGames {

  private List<LottoGame> lottoGames;

  public LottoGames(final List<LottoGame> lottoGames) {
    this.lottoGames = lottoGames;
  }

  public int size() {
    return lottoGames.size();
  }

  public List<LottoGame> getLottoGames() {
    return Collections.unmodifiableList(this.lottoGames);
  }

  public Statistics calculateStatistics(List<Integer> winNumbers) {
    LottoBalls winBalls = toLottoBallList(winNumbers);
    List<Integer> countList = new ArrayList<>();
    for (LottoGame lottoGame : lottoGames) {
      countList.add(lottoGame.countMatchNumber(winBalls));
    }
    return new Statistics(countList);
  }

  private LottoBalls toLottoBallList(List<Integer> winNumbers) {
    return new LottoBalls(
        winNumbers.stream()
        .map(LottoBall::new)
        .collect(Collectors.toList())
    );
  }
}
