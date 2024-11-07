package lotto.controller;

import lotto.domain.*;
import lotto.random.LottoGenerator;
import lotto.random.RandomLottoNumbers;
import lotto.ui.InputView;
import lotto.ui.PrintView;

public class LottoMain {
    public static void main(String[] args) {

        LottoGenerator lottoGenerator = new RandomLottoNumbers();
        int purchaseAmount = InputView.purchaseAmount();
        int manualTryCount = InputView.manualTryCount();
        TryCount tryCount = TryCount.initTryCount(purchaseAmount, manualTryCount);

        Lotto manualLotto = InputView.manualLottoNumber(manualTryCount);
        int tryNumber = tryCount.getTryCount();
        Lotto lotto = Lotto.initAllRoundLottoNumbers(manualLotto, lottoGenerator, tryNumber);

        PrintView.printManualAndRandomTryCount(manualTryCount, tryNumber);
        PrintView.printLottoList(lotto);

        LottoResult lottoResult = lotto.winningRanks(new WinningLotto(InputView.lottoWinnerNumbers(), InputView.lottoBonusNumbers()));

        PrintView.printWinningStatisticsPreview();
        PrintView.printWinningCount(lottoResult);
        PrintView.printMargin(lottoResult.calculateMarginPercent(purchaseAmount));
    }
}
