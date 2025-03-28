package lotto;

import view.InputView;

public class LottoApplication {

    public static void main(String[] args) {

        Integer lottoPurchaseAmount = InputView.showLottoPurchaseAmountInput();
        System.out.println(lottoPurchaseAmount);
    }
}
