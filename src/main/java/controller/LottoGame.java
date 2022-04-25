package controller;

import domain.Lotto;
import view.InputView;
import view.ResultView;

public class LottoGame {
    public static void main(String[] args) {
        Lotto lotto =  new Lotto(InputView.inputHowMoney());
        ResultView.printHowLottoCount(lotto.boughtLottoCount());
    }
}
