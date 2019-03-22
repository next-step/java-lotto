package lottogame;

import lottogame.domain.*;
import lottogame.service.LottoNumberGeneratorImpl;
import lottogame.view.InputView;
import lottogame.view.ResultView;

import java.util.List;

public class ConsoleApplicationLauncher {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
        PurchaseCount purchaseCount = InputView.getPurchaseCount(purchaseAmount.getLottoCount());
        List<LottoNumberPackage> manualNumbers = InputView.getManualNumbers(purchaseCount.getManualCount());

        LottoTicket lottoTicket = new LottoTicket(new PurchaseInfo(purchaseAmount, purchaseCount), manualNumbers, new LottoNumberGeneratorImpl());
        ResultView.showPurchaseResult(lottoTicket);

        LottoNumberPackage winningNumbers = InputView.getWinningNumbers();
        WinningInfo winningInfo = InputView.getWinningInfoByBonusNumber(winningNumbers);
        LottoResult lottoResult = new LottoResult(lottoTicket, winningInfo);
        ResultView.showWinningResult(lottoResult);
    }
}