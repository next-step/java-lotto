package lotto;

import java.util.List;
import lotto.controller.LottoMachine;
import lotto.domain.LottoCount;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.Money;
import lotto.domain.ResultGroup;
import lotto.domain.lotto.WinningLotto;
import lotto.view.InputView;

public class LottoApplication {


    public static void main(String[] args) {
        Money money = getMoneyFromUser();
        LottoCount manualCount = getManualCount();
        LottoCount autoCount = initializeAutoCount(money, manualCount);
        LottoTicket lottoTicket = purchaseLotto(autoCount, manualCount);
        LottoMachine.showLottoCount(manualCount, autoCount);
        LottoMachine.showLottoTicket(lottoTicket);
        WinningLotto winningLotto = getWinningLotto();
        ResultGroup resultGroup = LottoMachine.getResult(lottoTicket, winningLotto);
        LottoMachine.showResults(resultGroup, money);
    }

    private static LottoTicket purchaseLotto(LottoCount autoCount, LottoCount manualCount) {
        List<String> manualLottos = InputView.getManualLotto(manualCount.count());
        return LottoMachine.purchaseLotto(autoCount, manualLottos);
    }

    private static LottoCount getManualCount() {
        String manualCount = InputView.getManualLottoCount();
        return LottoCount.from(manualCount);
    }

    private static WinningLotto getWinningLotto() {
        String winningLottoLine = InputView.getWinningLotto();
        String bonusBall = InputView.getBonusBall();
        return LottoMachine.generateWinningLotto(winningLottoLine, bonusBall);
    }

    private static LottoCount initializeAutoCount(Money money, LottoCount manualCount) {
        LottoCount totalCount = LottoCount.from(money);
        return totalCount.minus(manualCount);
    }

    private static Money getMoneyFromUser() {
        String inputMoney = InputView.getMoneyToPurchase();
        return new Money(inputMoney);
    }
}
