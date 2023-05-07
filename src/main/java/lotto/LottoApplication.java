package lotto;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoGameSetting;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.game.LottoPurchasePrice;
import lotto.domain.game.LottoWinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main (String[] args) throws IOException {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    final int lottoPrice = inputView.getLottoPrice();
    final int manualLottoRoundCount = inputView.getManualLottoNumberCount();

    List<List<Integer>> manualLottoRounds = Collections.emptyList();
    if (manualLottoRoundCount > 0) {
      manualLottoRounds = inputView.generateManualLottoRound(manualLottoRoundCount);
    }

    final LottoGameSetting gameSetting = LottoGameSetting.ofKorea645LottoSetting();
    final LottoGame lottoGame = new LottoGame(manualLottoRounds, lottoPrice, gameSetting);

    resultView.showLottoRounds(manualLottoRoundCount, lottoGame.getLottoRounds());

    final List<Integer> lastWeekLottoNumbers = inputView.getLastWeekLottoNumbers();
    final int lastWeekBonusNumber = inputView.getBonusNumber();

    final LottoWinningNumber winningNumber = new LottoWinningNumber(lastWeekLottoNumbers, lastWeekBonusNumber);
    final LottoGameStatistics statistics = lottoGame.play(winningNumber);

    resultView.displayStatistics(statistics);
    inputView.tearDown();
  }
}
