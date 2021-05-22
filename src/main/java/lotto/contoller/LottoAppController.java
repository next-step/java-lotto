package lotto.contoller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoReport;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.PrintView;

import java.util.List;

public class LottoAppController {
    public void run() {
        List<Lotto> purchasedLottos = buyLotto();
        PrintView.showPurchasedLotto(purchasedLottos);

        LottoReport report = getReport(purchasedLottos);
        PrintView.showLottoReport(report);
    }

    private List<Lotto> buyLotto() {
        PrintView.askPurchaseAmountMessage();
        int purchaseAmount = InputView.getLottoPurchaseAmount();
        return LottoMachine.buyWith(purchaseAmount);
    }

    private LottoReport getReport(List<Lotto> purchasedLottos) {
        PrintView.askWinningNumber();
        List<Integer> lastWinningNumbers = InputView.getLastWinningNumber();
        PrintView.askBonusNumber();
        int bonusNumber = InputView.getBonusNumber();
        return new LottoReport(new WinningLotto(lastWinningNumbers, bonusNumber), purchasedLottos);
    }
}
