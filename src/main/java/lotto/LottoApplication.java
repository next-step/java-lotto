package lotto;

import lotto.domain.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        int amount = InputView.inputPurchaseAmount();
        System.out.println("amount: " + amount);
        String winningNumbers = InputView.inputWinningNumbers();
        System.out.println("winningNumbers: " + winningNumbers);
    }
}
