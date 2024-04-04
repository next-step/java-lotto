package lottogame;

import java.util.List;
import lottogame.domain.LottoGame;
import lottogame.domain.LottosBundle;
import lottogame.domain.Money;
import lottogame.domain.Number;
import lottogame.domain.Numbers;
import lottogame.domain.WinningLottos;
import lottogame.view.InputView;
import lottogame.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        Money money = InputView.requestMoney();
        ResultView.printLinkBreak();
        LottoGame lottoGame = new LottoGame();
        Number countOfLottos = lottoGame.calculateCountOfLottos(money);
        Number manualCountOfLotto = InputView.requestCountOfManualLottos(countOfLottos);
        ResultView.printLinkBreak();
        List<Numbers> manualInputNumbers = InputView.requestMultipleManualLottos(manualCountOfLotto);

        LottosBundle lottosBundleOfManual = lottoGame.createLottosBundle(manualInputNumbers);
        LottosBundle lottosBundleOfAuto = lottoGame.createLottosBundle(countOfLottos.minus(manualCountOfLotto));

        LottosBundle lottosBundle = lottosBundleOfManual.merge(lottosBundleOfAuto);
        ResultView.printAutoAndManualLottosCount(lottosBundleOfManual, lottosBundleOfAuto);
        ResultView.printLottos(lottosBundle);

        Numbers winningLottosNumbers = InputView.requestWinningLotto();
        Number bonusNumber = InputView.requestBonusNumber();
        WinningLottos winningLotto = lottoGame.createWinningLotto(winningLottosNumbers, bonusNumber);

        ResultView.printWinningResult(lottoGame.checkRanks(winningLotto, lottosBundle));
        ResultView.printReturnOfRate(lottoGame.calculateReturnOfRate(winningLotto, lottosBundle));
    }
}
