package lotto;

import lotto.numbers.LottoBundle;
import lotto.numbers.WinningNumberCreator;
import lotto.views.InputView;
import lotto.views.OutputView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputAmount();
        LottoBundle lottoBundle = new LottoBundle(purchaseAmount / LottoWinningStats.PRICE);
        OutputView.printNumbers(lottoBundle);

        String inputNumbers = InputView.inputLastWinningNumbers();
        int bonusNumber = InputView.inputbonusBall();

        LottoWinningStats lottoWinningStats = new LottoWinningStats(lottoBundle, WinningNumberCreator.getNumbers(inputNumbers));
        OutputView.printWinningStatsResult(lottoWinningStats, purchaseAmount);
    }
}
