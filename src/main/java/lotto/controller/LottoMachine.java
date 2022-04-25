package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    public void pull() {
        int price = InputView.inputPrice();
        OutputView.outputLottoNumbers(price);
        System.out.println();

        String previousWeekWinningNumber = InputView.inputPreviousWeekWinningNumber();
        System.out.println("previousWeekWinningNumber = " + previousWeekWinningNumber);
    }
}
