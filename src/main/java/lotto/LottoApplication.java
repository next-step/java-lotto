package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        Money money = getMoneyByInput();
        List<Lotto> manualLottos = getManualLottos();
        lottoMachine.purchaseLotto(money, manualLottos);
        ResultView.showCount(lottoMachine.getPurchaseLottoCount());
        ResultView.showLottos(lottoMachine.getLottos());
        WinningLotto winningLotto = InputView.getWinningLotto();
        ResultView.showResult(lottoMachine.getResult(winningLotto), money);
    }

    private static List<Lotto> getManualLottos() {
        int manualCount = InputView.getManualCount();
        return InputView.getManualLotto(manualCount);
    }

    private static Money getMoneyByInput() {
        String inputMoney = InputView.getLottoMoney();
        return new Money(inputMoney);
    }

}
