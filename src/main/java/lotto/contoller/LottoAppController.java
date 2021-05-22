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
        // TODO bonusNumber 사용자에게 입력 받은 값으로 변경
        return new LottoReport(new WinningLotto(lastWinningNumbers, 1), purchasedLottos);
    }
}
