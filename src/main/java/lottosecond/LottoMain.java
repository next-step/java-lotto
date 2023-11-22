package lottosecond;

import lottosecond.domain.*;
import lottosecond.domain.lotto.*;
import lottosecond.domain.lottomaker.AutoLottoNumberGenerator;
import lottosecond.domain.lottomaker.LottoMaker;
import lottosecond.domain.lottomaker.ManualLottoNumberGenerator;
import lottosecond.view.InputView;
import lottosecond.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        TotalLottoCount lottoCount = new TotalLottoCount(new Money(inputView.inputLottoBuyMoney()), inputView.manualLottoCount());

        LottoMaker manualLottoMaker = new LottoMaker(new ManualLottoNumberGenerator());
        LottoMaker autoLottoMaker = new LottoMaker(new AutoLottoNumberGenerator());

        inputView.printManualLotto();
        Lottos manualLottos = manualLottoMaker.makeLottos(lottoCount.getManualLottoCount());
        Lottos autoLottos = autoLottoMaker.makeLottos(lottoCount.getAutoLottoCount());

        Lottos lottos = Lottos.makeTotalLottos(manualLottos, autoLottos);

        outputView.printManualAndAutoLottoInfo(lottoCount);
        outputView.printLottoListInfo(lottos);

        inputView.printWinningNumbers();
        Lotto winningLotto = manualLottoMaker.makeLotto();

        WinningCondition winningCondition = new WinningCondition(winningLotto, LottoNumber.of(inputView.inputBonusNumber()));

        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningCondition);
        outputView.printWinnerStatistics(winnerBoard);

        EarningRateCalculator earningRateCalculator = new EarningRateCalculator();
        double earningRate = earningRateCalculator.calculateEarningRate(winnerBoard, lottos);
        outputView.printEarningRate(earningRate);
    }
}
