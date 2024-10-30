package lotto.controller;

import lotto.domain.*;
import lotto.random.LottoGenerator;
import lotto.random.RandomLottoNumbers;
import lotto.ui.InputView;
import lotto.ui.PrintView;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = InputView.purchaseAmount(scanner);
        LottoGenerator lottoGenerator = new RandomLottoNumbers();
        TryCount tryCount = TryCount.initTryCount(purchaseAmount);

        int tryNumber = tryCount.getTryCount();
        Lotto lotto = Lotto.initAllRoundLottoNumbers(lottoGenerator, tryNumber);

        PrintView.printLottoTryCount(tryNumber);
        PrintView.printLottoList(lotto.totalRoundLottoNumberList());

        LottoResult lottoResult = new LottoResult();
        LottoNumbers lottoNumbers = new LottoNumbers(InputView.lottoWinnerNumbers(scanner));

        lottoResult.updateWinningCountList(lotto.lottoRankList(lottoNumbers
                ,InputView.lottoBonusNumbers(new Scanner(System.in))));

        PrintView.printWinningStatisticsPreview();
        PrintView.printWinningCount(lottoResult.getLottoWinningCountsMap());
        PrintView.printMargin(lottoResult.calculateMarginPercent().calculateMarginPercent(purchaseAmount));
    }
}
