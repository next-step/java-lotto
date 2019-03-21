package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

import java.util.Map;

public class LottoConsoleApp {

    public static void main(String[] args) {
        final long purchaseAmount = ConsoleInput.inputPurchaseAmount();

        final LottoList lottos = LottoMachine.purchase(purchaseAmount);

        ConsoleOutput.printLottoCount(lottos.size());
        ConsoleOutput.printLottos(lottos);

        final Lotto winningLotto = ConsoleInput.inputLastWinningNumbers();
        final Map<Prize, LottoList> winningResult = LottoMachine.getWinningResult(lottos, winningLotto);

        ConsoleOutput.printWinningStatistics(winningResult);
        ConsoleOutput.printEarningsRate(LottoMachine.getEarningsRate(winningResult, purchaseAmount));
    }
}
