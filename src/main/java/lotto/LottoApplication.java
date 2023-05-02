package lotto;

import lotto.view.InputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String budget = inputView.askBudget();

    }

}
