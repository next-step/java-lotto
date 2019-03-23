package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoConsoleApp {

    public static void main(String[] args) {
        final long purchaseAmount = ConsoleInput.inputPurchaseAmount();

        final LottoList lottos = LottoMachine.purchase(purchaseAmount);

        ConsoleOutput.printLottoCount(lottos.size());
        ConsoleOutput.printLottos(lottos);

        final WinningLotto winningLotto = ConsoleInput.inputLastWinningNumbers();
        final WinningResults winningResults = LottoMachine.getWinningResults(lottos, winningLotto);

        ConsoleOutput.printWinningStatistics(winningResults);
        ConsoleOutput.printEarningsRate(LottoMachine.getEarningsRate(winningResults, purchaseAmount));
    }
}
