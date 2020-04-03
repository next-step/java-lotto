package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Price inputPrice = inputView.inputPrice();
        int manualCount = inputView.inputManualCount();

        Lotteries manuals = inputView.inputManualLottoNumbers(manualCount);
        Lotteries lotteries = LottoStore.sell(inputPrice, manuals);

        OutputView.printLotteryCount(manualCount, lotteries.count());
        OutputView.printLotteries(lotteries.getLottoNumbers());

        LottoNumbers winningLotteNumbers = inputView.inputLastWeekendWinningLottery();
        LottoNumber bonusBall = inputView.inputBonusBall();

        WinningLotto winningLotto = WinningLotto.of(winningLotteNumbers, bonusBall);
        LottoResult lottoResult = lotteries.analyzeWin(winningLotto);

        OutputView.printLottoResult(lottoResult.getChart());
        OutputView.printRatio(lottoResult.ratio(inputPrice));
    }
}
