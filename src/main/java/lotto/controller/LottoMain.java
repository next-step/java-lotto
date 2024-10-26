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
        Lotto lotto = new Lotto(lottoGenerator,purchaseAmount);

        PrintView.printLottoTryCount(lotto.getTryCount());
        PrintView.printLottoList(lotto.totalRoundLottoNumberList());

        LottoWinner lottoWinner = new LottoWinner();
        lottoWinner.updateWinningCountList(lotto.lottoRankList(new LottoNumbers(InputView.lottoWinnerNumbers(scanner))));

        PrintView.printWinningStatisticsPreview();
        PrintView.printWinningCount(lottoWinner.getLottoWinningCountsMap());
        PrintView.printMargin(lottoWinner.calculateMarginPercent(purchaseAmount));
    }
}
