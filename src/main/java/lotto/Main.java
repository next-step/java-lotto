package lotto;

import lotto.numbers.Lotto;
import lotto.numbers.WinningNumbers;
import lotto.views.InputView;
import lotto.views.OutputView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputAmount();
        Lotto lotto = new Lotto(purchaseAmount / LottoWinningStats.PRICE);
        OutputView.printNumbers(lotto);

        String inputNumbers = InputView.inputLastWinningNumbers();
        LottoWinningStats lottoWinningStats = new LottoWinningStats(lotto, WinningNumbers.getNumbers(inputNumbers));
        OutputView.printWinningStatsResult(lottoWinningStats, purchaseAmount);
    }
}
