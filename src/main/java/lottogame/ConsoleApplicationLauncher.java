package lottogame;

import lottogame.domain.LottoTicket;
import lottogame.domain.LottoResult;
import lottogame.domain.PurchaseAmount;
import lottogame.domain.WinningNumbers;
import lottogame.view.InputView;
import lottogame.view.ResultView;

public class ConsoleApplicationLauncher {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
        LottoTicket lottoTicket = new LottoTicket(purchaseAmount);
        ResultView.showPurchasedResult(lottoTicket);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        LottoResult lottoResult = new LottoResult(lottoTicket, winningNumbers);
        ResultView.showWinningResult(lottoResult);
    }
}