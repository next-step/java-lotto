package lotto;

import java.io.IOException;
import java.util.List;
import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoGameSetting;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.game.LottoWinningNumber;
import lotto.domain.raffle.BaseKoreaLottoRaffleGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main (String[] args) throws IOException {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    final int lottoPrice = inputView.getLottoPrice();
    final int manualLottoNumberCount = inputView.getManualLottoNumberCount();

    final LottoGame lottoGame = initLottoGame(lottoPrice, manualLottoNumberCount, inputView);
    resultView.showLottoRounds(lottoGame.getLottoRounds());

    final List<Integer> lastWeekLottoNumbers = inputView.getLastWeekLottoNumbers();
    final int lastWeekBonusNumber = inputView.getBonusNumber();

    final LottoWinningNumber winningNumber = new LottoWinningNumber(lastWeekLottoNumbers, lastWeekBonusNumber);
    final LottoGameStatistics statistics = lottoGame.play(winningNumber);

    resultView.displayStatistics(statistics);
    inputView.tearDown();
  }

  private static LottoGame initLottoGame(int lottoPrice, int manualLottoNumberCount, InputView inputView) throws IOException {
    final LottoGameSetting gameSetting = LottoGameSetting.builder()
        .raffleGenerator(new BaseKoreaLottoRaffleGenerator())
        .distinctNumberOnly(true)
        .pricePerGame(1000)
        .build();

    // 로또 자동만 존재하는 경우
    if (manualLottoNumberCount == 0) {
      return LottoGame.ofAutoOnly(lottoPrice, gameSetting);
    }

    final List<List<Integer>> manualLottoRounds = inputView.generateManualLottoRound(manualLottoNumberCount);
    return LottoGame.ofAutoManualMixed(manualLottoRounds, lottoPrice, gameSetting);
  }
}
