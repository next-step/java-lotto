package lotto.contoller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottoMachine;
import lotto.domain.LottoReport;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.PrintView;

public class LottoAppController {
    public void run() {
        Lottos purchasedLottos = buyLotto();
        PrintView.showPurchasedLotto(purchasedLottos);

        LottoReport report = getReport(purchasedLottos);
        PrintView.showLottoReport(report);
    }

    private Lottos buyLotto() {
        PrintView.askPurchaseAmountMessage();
        int purchaseAmount = InputView.getLottoPurchaseAmount();
        return LottoMachine.buyWith(purchaseAmount);
    }

    private LottoReport getReport(Lottos purchasedLottos) {
        PrintView.askWinningNumber();
        Lotto lastWinningNumbers = new Lotto(InputView.getLastWinningNumber());
        PrintView.askBonusNumber();
        int bonusNumber = InputView.getBonusNumber();
        return new LottoReport(new WinningLotto(lastWinningNumbers, bonusNumber), purchasedLottos);
    }
}
