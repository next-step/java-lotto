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
        getManualInput(lottoMachine, money);
        lottoMachine.purchaseAutoLotto(money);
        ResultView.showCount(lottoMachine.getPurchaseLottoCount());
        ResultView.showLottos(lottoMachine.getLottos());
        WinningLotto winningLotto = InputView.getWinningLotto();
        ResultView.showResult(lottoMachine.getResult(winningLotto), money);
    }

    private static void getManualInput(LottoMachine lottoMachine, Money money) {
        int manualCount = InputView.getManualCount();
        if (manualCount > money.getLottoCount()) {
            throw new IllegalArgumentException("금액보다 많은 수동 갯수를 요청했습니다");
        }
        List<Lotto> lottos = InputView.getManualLotto(manualCount);
        lottoMachine.purchaseManualLotto(manualCount, lottos);
    }

    private static Money getMoneyByInput() {
        String inputMoney = InputView.getLottoMoney();
        return new Money(inputMoney);
    }

}
