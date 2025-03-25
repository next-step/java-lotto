package step2.lotto.controller;

import step2.lotto.model.Money;
import step2.lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        String purchaseAmount = inputView.getPurchaseAmount();
        Money money = new Money(purchaseAmount);
    }

}
