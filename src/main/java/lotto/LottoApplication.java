package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        Money money = getMoneyByInput();
        lottoMachine.purchaseLotto(money);
        ResultView.showCount(lottoMachine.getPurchaseLottoCount());
        ResultView.showLottos(lottoMachine.getLottos());
        Lotto winningLotto = InputView.getWinningLotto();
        ResultView.showResult(lottoMachine.getResult(winningLotto), money);
    }

    private static Money getMoneyByInput() {
        String inputMoney = InputView.getLottoMoney();
        return new Money(inputMoney);
    }

}
