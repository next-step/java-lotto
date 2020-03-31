package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

  private List<LottoGame> lottoGames;

  public Lotto(int autoCount) {
    this(autoCount, new ArrayList<>());
  }

  public Lotto(List<LottoGame> lottoGames) {
    this(0, lottoGames);
  }

  public List<LottoGame> getLottoGames() {
    return lottoGames;
  }

  public Lotto(int autoCount, List<LottoGame> lottoGames) {
    this.lottoGames = Stream.concat(
        Stream.generate(LottoGame::new).limit(autoCount),
        lottoGames.stream()
    ).collect(Collectors.toList());
  }

  public List<Rank> getRanks(WinningNumbers winningNumbers) {
    return lottoGames.stream()
        .map(winningNumbers::getRank)
        .collect(Collectors.toList());
  }
}
