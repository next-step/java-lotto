package lottogame;

import lottogame.domain.*;
import lottogame.service.LottoNumberGeneratorImpl;
import lottogame.view.InputView;
import lottogame.view.ResultView;

public class ConsoleApplicationLauncher {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
        LottoTicket lottoTicket = new LottoTicket(new PurchaseInfo(purchaseAmount), new LottoNumberGeneratorImpl());
        ResultView.showPurchasedResult(lottoTicket);

        LottoNumberPackage winningNumbers = InputView.getWinningNumbers();
        LottoNumber bonusNumber = InputView.getBonusNumber();
        LottoResult lottoResult = new LottoResult(lottoTicket, new WinningInfo(winningNumbers, bonusNumber));
        ResultView.showWinningResult(lottoResult);
    }
}