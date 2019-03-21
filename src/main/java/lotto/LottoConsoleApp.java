package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMachine;
import lotto.domain.WinningResults;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoConsoleApp {

    public static void main(String[] args) {
        final long purchaseAmount = ConsoleInput.inputPurchaseAmount();

        final LottoList lottos = LottoMachine.purchase(purchaseAmount);

        ConsoleOutput.printLottoCount(lottos.size());
        ConsoleOutput.printLottos(lottos);

        final Lotto winningLotto = ConsoleInput.inputLastWinningNumbers();
        final WinningResults winningResults = LottoMachine.getWinningResults(lottos, winningLotto);

        ConsoleOutput.printWinningStatistics(winningResults);
        ConsoleOutput.printEarningsRate(LottoMachine.getEarningsRate(winningResults, purchaseAmount));
    }
}
