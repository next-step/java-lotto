package lotto;

import lotto.numbers.LottoBundle;
import lotto.numbers.WinningNumbers;
import lotto.views.InputView;
import lotto.views.OutputView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputAmount();
        LottoBundle lottoBundle = new LottoBundle(purchaseAmount / LottoWinningStats.PRICE);
        OutputView.printNumbers(lottoBundle);

        String inputNumbers = InputView.inputLastWinningNumbers();
        LottoWinningStats lottoWinningStats = new LottoWinningStats(lottoBundle, WinningNumbers.getNumbers(inputNumbers));
        OutputView.printWinningStatsResult(lottoWinningStats, purchaseAmount);
    }
}
