package lotto.contoller;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMachine;
import lotto.domain.LottoReport;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.PrintView;

public class LottoAppController {
    public void run() {
        LottoList purchasedLottos = buyLotto();
        PrintView.showPurchasedLotto(purchasedLottos);

        LottoReport report = getReport(purchasedLottos);
        PrintView.showLottoReport(report);
    }

    private LottoList buyLotto() {
        PrintView.askPurchaseAmountMessage();
        int purchaseAmount = InputView.getLottoPurchaseAmount();
        return LottoMachine.buyWith(purchaseAmount);
    }

    private LottoReport getReport(LottoList purchasedLottos) {
        PrintView.askWinningNumber();
        Lotto lastWinningNumbers = new Lotto(InputView.getLastWinningNumber());
        PrintView.askBonusNumber();
        int bonusNumber = InputView.getBonusNumber();
        return new LottoReport(new WinningLotto(lastWinningNumbers, bonusNumber), purchasedLottos);
    }
}
