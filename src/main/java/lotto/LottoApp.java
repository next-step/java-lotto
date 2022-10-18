package lotto;

import lotto.view.InputView;

public class LottoApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int purchaseMoney = inputView.inputPurchaseMoney();
    }
}
