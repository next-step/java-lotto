package lottosecond;

import lottosecond.domain.*;
import lottosecond.domain.lotto.*;
import lottosecond.view.InputView;
import lottosecond.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoCount lottoCount = new LottoCount(inputView.inputLottoBuyMoney(), inputView.manualLottoCount());
        LottoMaker lottoMaker = new LottoMaker(new StringToLottoConvertor(), lottoCount);

        inputView.printManualLotto();
        Lottos lottos = lottoMaker.makeTotalLottos(new LottoShuffler(), inputView.inputManualLottoNumber(lottoCount.getManualLottoCount()));

        outputView.printManualAndAutoLottoInfo(lottoCount);
        outputView.printLottoListInfo(lottos);

        Lotto winningLotto = lottoMaker.makeLotto(inputView.inputWinningNumbers());

        int bonusNumber = inputView.inputBonusNumber();
        WinningCondition winningCondition = new WinningCondition(winningLotto, LottoNumber.of(bonusNumber));

        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningCondition);
        outputView.printWinnerStatistics(winnerBoard);

        EarningRateCalculator earningRateCalculator = new EarningRateCalculator();
        double earningRate = earningRateCalculator.calculateEarningRate(winnerBoard, lottos);
        outputView.printEarningRate(earningRate);
    }
}
