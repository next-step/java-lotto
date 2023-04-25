package lotto;

import lotto.view.InputView;

public class LottoGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String formula = inputView.askFormula();

    }
}
