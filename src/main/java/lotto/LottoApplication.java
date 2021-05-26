package lotto;

import lotto.domain.*;
import lotto.dto.PurchaseMoney;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoApplication {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoApplication() {
        lottoInputView = new LottoInputView();
        lottoOutputView = new LottoOutputView();
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.run();
    }

    private void run() {
        PurchaseMoney purchaseMoney = lottoInputView.questionPurchaseMoney();
        LottoGames lottoGames = LottoGames.purchase(purchaseMoney);

        printPurchaseResult(lottoGames);

        WinningLottoNumber winningLottoNumber = lottoInputView.questionLastPrizeNumber();
        LottoResult lottoResult = winningLottoNumber.decidePrize(lottoGames);

        lottoOutputView.printPrizeStatistics(lottoResult, purchaseMoney);
    }

    private void printPurchaseResult(LottoGames lottoGames) {
        lottoOutputView.printLottoGamesSize(lottoGames);
        lottoOutputView.printLottoGame(lottoGames);
    }
}
