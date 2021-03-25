package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        Money money = getMoneyByInput();
        lottoMachine.purchaseLotto(money);
        ResultView.showCount(lottoMachine.getPurchaseLottoCount());
        ResultView.showLottos(lottoMachine.getLottos());
        WinningLotto winningLotto = InputView.getWinningLotto();
        ResultView.showResult(lottoMachine.getResult(winningLotto), money);
    }

    private static Money getMoneyByInput() {
        String inputMoney = InputView.getLottoMoney();
        return new Money(inputMoney);
    }

}
