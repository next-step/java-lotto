package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.LottoCount;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.ResultGroup;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class LottoApplication {


    public static void main(String[] args) {
        Money money = getMoneyFromUser();
        LottoCount lottoCount = initializeCount(money);
        LottoMachine.showLottoCount(lottoCount);
        LottoTicket lottoTicket = LottoMachine.purchaseLotto(lottoCount);
        LottoMachine.showLottoTicket(lottoTicket);
        WinningLotto winningLotto = getWinningLotto();
        ResultGroup resultGroup = LottoMachine.getResult(lottoTicket, winningLotto);
        LottoMachine.showResults(resultGroup, money);
    }

    private static WinningLotto getWinningLotto() {
        String winningLottoLine = InputView.getWinningLotto();
        return LottoMachine.generateWinningLotto(winningLottoLine);
    }

    private static LottoCount initializeCount(Money money) {
        return LottoCount.from(money);
    }

    private static Money getMoneyFromUser() {
        String inputMoney = InputView.getMoneyToPurchase();
        return new Money(inputMoney);
    }
}
