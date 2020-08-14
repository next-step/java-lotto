package com.hskim.lotto;

import com.hskim.lotto.model.LottoGame;
import com.hskim.lotto.model.NumberMaker;
import com.hskim.lotto.model.PurchasePrice;
import com.hskim.lotto.model.RandomNumberMaker;
import com.hskim.lotto.ui.LottoInputView;
import com.hskim.lotto.ui.LottoResultView;

public class LottoSimulator {

    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        LottoResultView lottoResultView = new LottoResultView();
        NumberMaker numberMaker = new RandomNumberMaker();
        LottoGame lottoGame;
        PurchasePrice purchasePrice;

        lottoInputView.printPurchasePhrase();
        purchasePrice = lottoInputView.getPurchasePriceFromInput();
        lottoGame = new LottoGame(purchasePrice, numberMaker);

        lottoResultView.printPurchaseNum(lottoGame.makeTicketsSizeString());
        lottoResultView.printString(lottoGame.makeLottoTicketsString());
    }
}
