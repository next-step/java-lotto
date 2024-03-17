package lotto;

import lotto.controller.LottoConsole;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        LottoConsole lottoConsole = new LottoConsole(new InputView(), new OutputView());
        lottoConsole.start();
    }
}
