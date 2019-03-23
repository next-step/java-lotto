package lottogame;

import lottogame.domain.*;
import lottogame.service.LottoNumberGeneratorImpl;
import lottogame.view.ConsoleInputView;
import lottogame.view.ConsoleResultView;

import java.util.List;

public class ConsoleApplicationLauncher {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = ConsoleInputView.getPurchaseAmount();
        PurchaseCount purchaseCount = ConsoleInputView.getPurchaseCount(purchaseAmount.getLottoCount());
        List<LottoNumberPackage> manualNumbers = ConsoleInputView.getManualNumbers(purchaseCount.getManualCount());

        LottoTicket lottoTicket = new LottoTicket(new PurchaseInfo(purchaseAmount, purchaseCount), manualNumbers, new LottoNumberGeneratorImpl());
        ConsoleResultView.showPurchaseResult(lottoTicket);

        LottoNumberPackage winningNumbers = ConsoleInputView.getWinningNumbers();
        WinningInfo winningInfo = ConsoleInputView.getWinningInfoByBonusNumber(winningNumbers);
        LottoResult lottoResult = new LottoResult(new LottoResultMaker(lottoTicket, winningInfo));
        ConsoleResultView.showWinningResult(lottoResult);
    }
}