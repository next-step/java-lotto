package lotto.domain;

import lotto.dto.AnalysisSheet;
import lotto.dto.TotalOrderedLottoGameNumbers;
import lotto.dto.WinningNumbersAndBonusNumber;

import java.util.Objects;

public class LottoMachine {

  private final GameGenerator gameGenerator;
  private final LottoGames orderedGames;

  public LottoMachine(GameGenerator gameGenerator) {
    this.gameGenerator = gameGenerator;
    this.orderedGames = gameGenerator.generateNewLottoGames();
  }

  public TotalOrderedLottoGameNumbers peekOrderedGames() {
    return orderedGames.peekTotalLottoGameNumbers();
  }

  public AnalysisSheet confirmPrizeOrderedLottos(WinningNumbersAndBonusNumber winningNumbersAndBonusNumber) {
    LottoGame winningGame = gameGenerator.createLottoGame(winningNumbersAndBonusNumber.getWinningNumbers());
    WinningConditions winningConditions = WinningConditions.of(winningGame, winningNumbersAndBonusNumber.getBonusNumber());
    TotalRankings totalRankings = orderedGames.matchRankings(winningConditions);
    return new AnalysisSheet(totalRankings, gameGenerator.peekTotalOrderedAmount());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoMachine that = (LottoMachine) o;
    return gameGenerator.equals(that.gameGenerator) && orderedGames.equals(that.orderedGames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gameGenerator, orderedGames);
  }
}
