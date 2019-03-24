package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoConsoleApp {

    public static void main(String[] args) {
        final LottoMoney lottoMoney = ConsoleInput.inputPurchaseAmount();

        final LottoList manualLottos = ConsoleInput.inputManualLottos(lottoMoney.countOfLotto());
        int leftLottosCount = lottoMoney.countOfLotto() - manualLottos.size();

        LottoList totalLottos = null;
        if (leftLottosCount > 0) {
            final LottoList autoLottos = new LottoList(leftLottosCount);
            ConsoleOutput.printLottoCount(manualLottos.size(), autoLottos.size());

            totalLottos = LottoList.merge(manualLottos, autoLottos);
        }

        if (leftLottosCount == 0) {
            ConsoleOutput.printLottoCount(manualLottos.size(), 0);

            totalLottos = manualLottos;
        }

        ConsoleOutput.printLottos(totalLottos);

        final WinningLotto winningLotto = ConsoleInput.inputLastWinningNumbers();
        final WinningResults winningResults = LottoMatcher.calculateWinningResults(totalLottos, winningLotto);

        ConsoleOutput.printWinningStatistics(winningResults);
        ConsoleOutput.printEarningsRate(lottoMoney.calculateEarningsRate(winningResults));
    }
}
