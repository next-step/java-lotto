package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoConsoleApp {

    public static void main(String[] args) {
        final LottoMoney lottoMoney = ConsoleInput.inputPurchaseAmount();

        final LottoList lottos = ConsoleInput.inputManualLottos(lottoMoney.countOfLotto());

        ConsoleOutput.printLottoCount(lottos.sizeOfManuals(), lottos.sizeOfAutos());
        ConsoleOutput.printLottos(lottos);

        final WinningLotto winningLotto = ConsoleInput.inputLastWinningNumbers();
        final MatchResults matchResults = LottoMatcher.calculateMatchResults(lottos, winningLotto);

        ConsoleOutput.printWinningStatistics(matchResults);
        ConsoleOutput.printEarningsRate(lottoMoney.calculateEarningsRate(matchResults));
    }
}
