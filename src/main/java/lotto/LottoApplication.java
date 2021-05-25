package lotto;

import lotto.domain.*;
import lotto.dto.PurchaseMoney;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoApplication {

    private LottoInputView lottoInputView;
    private LottoOutputView lottoOutputView;
    private LottoSeller lottoSeller;

    public LottoApplication() {
        lottoInputView = new LottoInputView();
        lottoOutputView = new LottoOutputView();
        lottoSeller = new LottoSeller(new LottoGameAutoGenerator());
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.run();
    }

    private void run() {
        PurchaseMoney purchaseMoney = lottoInputView.questionPurchaseMoney();
        LottoGames lottoGames = lottoSeller.sell(purchaseMoney);

        printPurchaseResult(lottoGames);

        WinningLottoNumber winningLottoNumber = lottoInputView.questionLastPrizeNumber();
        LottoResult lottoResult = winningLottoNumber.decidePrize(lottoGames);

        lottoOutputView.printPrizeStatics(lottoResult, purchaseMoney);
    }

    private void printPurchaseResult(LottoGames lottoGames) {
        lottoOutputView.printLottoGamesSize(lottoGames);
        lottoOutputView.printLottoGame(lottoGames);
    }
}
