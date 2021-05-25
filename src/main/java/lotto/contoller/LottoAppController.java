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
        Lottos purchasedLottos = buyLotto();
        PrintView.showPurchasedLotto(purchasedLottos);

        LottoReport report = getReport(purchasedLottos);
        PrintView.showLottoReport(report);
    }

    private Lottos buyLotto() {
        LottoMoney purchaseAmount = askPurchaseAmount();
        Lottos manual = askManualLottosWith(purchaseAmount);

        LottoMoney remainder = purchaseAmount.buyCountOfLotto(manual.size());
        Lottos auto = LottoMachine.buyWith(remainder);

        return Lottos.merge(manual, auto);
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
