package lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.PurchaseAmount;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistic;
import lotto.view.Input;
import lotto.view.Output;

public class Main {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(Input.inputPurchaseAmount());
        Output.printPurchaseCount(purchaseAmount);

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        List<Lotto> autoLottos = Lotto.createAutoLottos(lottoMachine.calculateExecuteCount());
        Output.printAutoLotto(autoLottos);

        WinningStatistic winningStatistic = lottoMachine.startLotto(autoLottos,
            WinningNumbers.fromValues(Input.inputWinningNumbers()));

        Output.printLottoResult(winningStatistic);
    }
}
