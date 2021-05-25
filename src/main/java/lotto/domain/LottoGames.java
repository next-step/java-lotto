package lotto.domain;

import lotto.dto.TotalOrderedLottoGameNumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoGames {

  private final List<LottoGame> games;

  public LottoGames(List<LottoGame> games) {
    this.games = games;
  }

  public TotalRankings matchRankings(WinningConditions winningConditions) {
    List<LottoRanking> matchResult = games.stream()
        .map(winningConditions::matchConditions)
        .collect(Collectors.toList());
    return new TotalRankings(matchResult);
  }

  public TotalOrderedLottoGameNumbers peekTotalLottoGameNumbers() {
    return new TotalOrderedLottoGameNumbers(games);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoGames that = (LottoGames) o;
    return games.equals(that.games);
  }

  @Override
  public int hashCode() {
    return Objects.hash(games);
  }
}
