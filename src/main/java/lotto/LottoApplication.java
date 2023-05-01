package lotto;

import java.io.IOException;
import java.util.List;
import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.game.LottoWinningNumber;
import lotto.domain.raffle.BaseKoreaLottoRaffleGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main (String[] args) throws IOException {
    InputView inputView = new InputView();

    final int lottoPrice = inputView.getLottoPrice();
    final boolean isDistinctNumberOnly = true;

    final LottoGame lottoGame = new LottoGame(lottoPrice, new BaseKoreaLottoRaffleGenerator(), isDistinctNumberOnly);
    ResultView.showLottoRounds(lottoGame.getLottoRounds());

    final List<Integer> lastWeekLottoNumbers = inputView.getLastWeekLottoNumbers();
    final int lastWeekBonusNumber = inputView.getBonusNumber();

    final LottoWinningNumber winningNumber = new LottoWinningNumber(lastWeekLottoNumbers, lastWeekBonusNumber);
    final LottoGameStatistics statistics = lottoGame.play(winningNumber);

    ResultView.displayStatistics(statistics);
    inputView.tearDown();
  }
}
