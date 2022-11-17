package lotto;

import lotto.numbers.Lotto;
import lotto.numbers.LottoBundle;
import lotto.numbers.WinningNumbers;
import lotto.views.InputView;
import lotto.views.OutputView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputAmount();
        LottoBundle lottoBundle = new LottoBundle(purchaseAmount / Lotto.PRICE);
        OutputView.printNumbers(lottoBundle);

        String inputNumbers = InputView.inputLastWinningNumbers();
        int bonusNumber = InputView.inputBonusBall();

        LottoWinningStats lottoWinningStats = new LottoWinningStats(lottoBundle, WinningNumbers.getNumbers(inputNumbers), bonusNumber);
        OutputView.printWinningStatsResult(lottoWinningStats, purchaseAmount);
    }
}
