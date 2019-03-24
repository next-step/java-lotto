package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoConsoleApp {

    public static void main(String[] args) {
        final long purchaseAmount = ConsoleInput.inputPurchaseAmount();

        final LottoMoney lottoMoney = new LottoMoney(purchaseAmount);

        final LottoList manualLottos = ConsoleInput.inputManualLottos(lottoMoney.countOfLotto());
        final LottoList autoLottos = new LottoList(lottoMoney.countOfLotto() - manualLottos.size());

        ConsoleOutput.printLottoCount(manualLottos.size(), autoLottos.size());

        final LottoList totalLottos = LottoList.merge(manualLottos, autoLottos);
        ConsoleOutput.printLottos(totalLottos);

        final WinningLotto winningLotto = ConsoleInput.inputLastWinningNumbers();
        final WinningResults winningResults = LottoMatcher.calculateWinningResults(totalLottos, winningLotto);

        ConsoleOutput.printWinningStatistics(winningResults);
        ConsoleOutput.printEarningsRate(lottoMoney.calculateEarningsRate(winningResults));
    }
}
