package com.techmoa.lotto;

import com.techmoa.lotto.view.InputView;

public class LottoStarter {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.enterLastWinnerNumber();
        inputView.getLastWinnerNumber();
        inputView.enterPurchaseAmount();
        inputView.getPurchaseAmount();
    }
}
