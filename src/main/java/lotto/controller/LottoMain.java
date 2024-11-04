package lotto.controller;

import lotto.domain.*;
import lotto.random.LottoGenerator;
import lotto.random.RandomLottoNumbers;
import lotto.ui.InputView;
import lotto.ui.PrintView;

public class LottoMain {
    public static void main(String[] args) {

        int purchaseAmount = InputView.purchaseAmount();
        LottoGenerator lottoGenerator = new RandomLottoNumbers();
        TryCount tryCount = TryCount.initTryCount(purchaseAmount);

        int tryNumber = tryCount.getTryCount();
        Lotto lotto = Lotto.initAllRoundLottoNumbers(lottoGenerator, tryNumber);

        PrintView.printLottoTryCount(tryNumber);
        PrintView.printLottoList(lotto);

        LottoResult lottoResult = lotto.updateWinningRankList(new WinningLotto(InputView.lottoWinnerNumbers(), InputView.lottoBonusNumbers()));

        PrintView.printWinningStatisticsPreview();
        PrintView.printWinningCount(lottoResult);
        PrintView.printMargin(lottoResult.calculateMarginPercent(purchaseAmount));
    }
}
