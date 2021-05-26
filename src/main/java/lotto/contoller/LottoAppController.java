package lotto.contoller;

import lotto.domain.LottoMoney;
import lotto.domain.Lottos;
import lotto.domain.LottoMachine;
import lotto.domain.LottoReport;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.PrintView;

import java.util.List;

public class LottoAppController {
    public void run() {
        LottoMoney purchaseAmount = askPurchaseAmount();
        Lottos manual = askManualLottosWith(purchaseAmount);
        Lottos auto = LottoMachine.buyWith(purchaseAmount);
        PrintView.showPurchasedLotto(manual, auto);

        LottoReport report = getReport(Lottos.merge(manual, auto));
        PrintView.showLottoReport(report);
    }


    private LottoMoney askPurchaseAmount() {
        PrintView.askPurchaseAmountMessage();
        return new LottoMoney(InputView.getLottoPurchaseAmount());
    }

    private Lottos askManualLottosWith(LottoMoney purchaseAmount) {
        PrintView.askCountOfManualLotto();
        int countOfManualLotto = InputView.getCountOfManualLotto();

        purchaseAmount.checkAffordable(countOfManualLotto);
        PrintView.askManualLotto();

        return InputView.getManualLottos(countOfManualLotto);
    }

    private LottoReport getReport(Lottos purchasedLottos) {
        PrintView.askWinningNumber();
        List<Integer> lastWinningNumbers = InputView.getLastWinningNumber();

        PrintView.askBonusNumber();
        int bonusNumber = InputView.getBonusNumber();

        return new LottoReport(new WinningLotto(lastWinningNumbers, bonusNumber), purchasedLottos);
    }
}
