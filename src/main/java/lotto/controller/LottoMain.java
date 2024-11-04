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
        TryCount tryCount = TryCount.initTryCount(purchaseAmount);

        int manualTryCount = InputView.manualTryCount();
        tryCount.updateWithManualTry(manualTryCount);
        Lotto manualLotto = InputView.manualLottoNumber(manualTryCount);
        int tryNumber = tryCount.getTryCount();
        Lotto lotto = Lotto.initAllRoundLottoNumbers(manualLotto, lottoGenerator, tryNumber);

        PrintView.printManualAndRandomTryCount(manualTryCount, tryNumber);
        PrintView.printLottoList(lotto);

        LottoResult lottoResult = lotto.updateWinningRankList(new WinningLotto(InputView.lottoWinnerNumbers(), InputView.lottoBonusNumbers()));

        PrintView.printWinningStatisticsPreview();
        PrintView.printWinningCount(lottoResult);
        PrintView.printMargin(lottoResult.calculateMarginPercent(purchaseAmount));
    }
}
