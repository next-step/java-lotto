package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameAutoGenerator;
import lotto.domain.LottoGames;
import lotto.domain.LottoSeller;
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
        PurchaseMoney purchaseMoney = questionPurchaseMoney();
    }

    private PurchaseMoney questionPurchaseMoney() {
        PurchaseMoney purchaseMoney = lottoInputView.questionPurchaseMoney();
        return purchaseMoney;
    }
}
