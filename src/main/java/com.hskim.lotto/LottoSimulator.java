package com.hskim.lotto;

import com.hskim.lotto.model.LottoGame;
import com.hskim.lotto.model.PurchasePrice;
import com.hskim.lotto.ui.LottoInputView;

/**
 * Created by hs kim on 2020/08/14
 */
public class LottoSimulator {

    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        LottoGame lottoGame = new LottoGame();
        PurchasePrice purchasePrice;

        lottoInputView.printPurchasePhrase();
        purchasePrice = lottoInputView.getPurchasePriceFromInput();
    }
}
