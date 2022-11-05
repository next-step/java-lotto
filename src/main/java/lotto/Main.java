package lotto;

import lotto.views.InputView;
import lotto.views.OutputView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputAmount();
        LottoProcessor lottoProcessor = new LottoProcessor(purchaseAmount);
        lottoProcessor.publish(purchaseAmount);

        String winningNumbers = InputView.inputLastWinningNumbers();
        lottoProcessor.calculateWinningStats(winningNumbers, purchaseAmount);
        OutputView.printWinningStatsResult(lottoProcessor, purchaseAmount);
    }
}
