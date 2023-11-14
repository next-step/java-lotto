package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.TextManipulator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

        public static void main(String args[]) {
                long purchaseAmount = InputView.scanPurchaseAmount();
                Lotto lotto = new Lotto(purchaseAmount);
                OutputView.printPurchaseCount(lotto.purchaseQuantity());

                OutputView.printGeneratedTickets(lotto.tickets());

                List<Integer> winningNumbers = TextManipulator.splitNumberTextByComma(
                    InputView.scanWinningNumberText());

                lotto.tickets().analyzeLottoResults(winningNumbers, purchaseAmount);
                OutputView.printResult(lotto);
        }
}
