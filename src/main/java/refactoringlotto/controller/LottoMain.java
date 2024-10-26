package refactoringlotto.controller;

import refactoringlotto.domain.*;
import refactoringlotto.random.LottoGenerator;
import refactoringlotto.random.RandomLottoNumbers;
import refactoringlotto.ui.InputView;
import refactoringlotto.ui.PrintView;

import java.util.List;
import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = InputView.purchaseAmount(scanner);
        TryCount tryCount = TryCount.initTryCount(purchaseAmount);
        int lottoTryCount = tryCount.getTryCount();
        PrintView.printLottoTryCount(lottoTryCount);

        LottoGenerator lottoGenerator = new RandomLottoNumbers();
        Lotto lotto = new Lotto(lottoGenerator,lottoTryCount);

        PrintView.printLottoList(lotto.totalRoundLottoNumberList());
        lotto.initWinningLottoNumbers(InputView.lottoWinnerNumbers(scanner));

        LottoWinningCounts lottoWinningCounts = new LottoWinningCounts();
        lottoWinningCounts.updateWinningCountList(lotto.lottoRankList());
        PrintView.printWinningStatisticsPreview();
        PrintView.printWinningCount(lottoWinningCounts.getLottoWinningCountsMap());
        MarginAmount marginAmount = new MarginAmount(lottoWinningCounts.winningAmount());
        PrintView.printMargin(marginAmount.calculateMarginPercent(purchaseAmount));



    }
}
