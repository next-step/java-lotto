package lottogame;

import lottogame.domain.LottosBundle;
import lottogame.domain.Money;
import lottogame.domain.Number;
import lottogame.domain.WinningLottos;
import lottogame.view.InputView;
import lottogame.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        ResultView.printLinkBreak();

        Number countOfLottos = LottosBundle.calculateCountOfLottos(InputView.requestMoney());
        Number manualCountOfLotto = InputView.requestCountOfManualLottos(countOfLottos);
        ResultView.printLinkBreak();

        LottosBundle lottosBundleOfManual = LottosBundle.manualFrom(InputView.requestMultipleManualLottos(manualCountOfLotto));
        LottosBundle lottosBundleOfAuto = LottosBundle.autoFrom(countOfLottos.minus(manualCountOfLotto));
        LottosBundle lottosBundle = lottosBundleOfManual.merge(lottosBundleOfAuto);
        ResultView.printAutoAndManualLottosCount(lottosBundleOfManual, lottosBundleOfAuto);
        ResultView.printLottos(lottosBundle);

        WinningLottos winningLottos = WinningLottos.of(InputView.requestWinningLotto(), InputView.requestBonusNumber());
        ResultView.printWinningResult(lottosBundle.checkRanks(winningLottos));
        ResultView.printReturnOfRate(lottosBundle.calculateReturnOfRate(winningLottos));
    }
}
