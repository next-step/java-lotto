package lotto_auto.domain;

import lotto_auto.io.InputView;
import lotto_auto.io.OutputView;


public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lotto lotto = new Lotto();

        OutputView outputView = new OutputView(lotto.getLottoNumberList());
        inputView.getWinningNumberComment();

        WinningNumber winningNumber = new WinningNumber(inputView.winningNumber, lotto.getLottoNumberList());
        winningNumber.compareMagicNumber();
        outputView.printStatistics();

    }
}
