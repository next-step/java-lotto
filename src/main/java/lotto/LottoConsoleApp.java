package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoConsoleApp {

    public static void main(String[] args) {
        final long purchaseAmount = ConsoleInput.inputPurchaseAmount();

        LottoMoney lottoMoney = new LottoMoney(purchaseAmount);
        final LottoList lottos = new LottoList(lottoMoney.countOfLotto());

        ConsoleOutput.printLottoCount(lottos.size());
        ConsoleOutput.printLottos(lottos);

        final WinningLotto winningLotto = ConsoleInput.inputLastWinningNumbers();
        final WinningResults winningResults = LottoMatcher.calculateWinningResults(lottos, winningLotto);

        ConsoleOutput.printWinningStatistics(winningResults);
        ConsoleOutput.printEarningsRate(lottoMoney.calculateEarningsRate(winningResults));
    }
}
